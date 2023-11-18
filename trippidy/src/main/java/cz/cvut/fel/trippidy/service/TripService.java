package cz.cvut.fel.trippidy.service;

import cz.cvut.fel.trippidy.dto.TripDto;
import cz.cvut.fel.trippidy.entity.Member;
import cz.cvut.fel.trippidy.entity.Trip;
import cz.cvut.fel.trippidy.entity.UserProfile;
import cz.cvut.fel.trippidy.entity.*;
import cz.cvut.fel.trippidy.enums.MemberRole;
import cz.cvut.fel.trippidy.mappers.Mapper;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.security.auth.message.AuthException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

//@ApplicationScoped
@Stateless
public class TripService {

    @PersistenceContext
    EntityManager entityManager;

    public List<TripDto> findTrips(String userId) {
        var res = entityManager.createNamedQuery(Trip.FIND_BY_USER_PROFILE_ID, Trip.class)
                .setParameter("userId", userId)
                .getResultStream()
                .map(Mapper.MAPPER::toDto)
                .collect(Collectors.toList());

        // don't include private items of other members
        for (var trip : res) {
            for (var member : trip.getMembers()) {
                if (!Objects.equals(member.getUserProfileId(), userId)) {
                    member.setItems(member.getItems().stream().filter(item -> !item.isPrivate()).collect(Collectors.toList()));
                }
            }
        }
        return res;
    }

    public Trip createTrip(TripDto tripDto) {
        var newTrip = Mapper.MAPPER.toEntity(tripDto);
        entityManager.persist(newTrip);

        return newTrip;

//        Member member = new Member();
//        member.setAccepted(true);
//        member.setRole("admin");
//        member.setUserProfile(userProfile);
//
//        Trip trip = new Trip();
//        trip.setName(tripDto.getName());
//        trip.setDateFrom(tripDto.getDateFrom());
//        trip.setDateTo(tripDto.getDateTo());
//        trip.addMember(member);
//        member.setTrip(trip);
//
//        entityManager.persist(trip);
//        //entityManager.persist(member);
//        return Mapper.MAPPER.toDto(trip);
    }

    public Trip deleteTrip(String userId, UUID tripId) throws AuthException {
        checkTripOwnership(userId, tripId);
        var trip = entityManager.find(Trip.class, tripId);
        trip.setDeleted(true);
        return trip;
    }

    public TripDto findTrip(String userId, UUID tripId) throws AuthException {
        var trip = entityManager.find(Trip.class, tripId);
        if (trip.getMembers().stream().map(x -> x.getUserProfile().getId()).anyMatch(x -> x.equals(userId))) {
            var res = Mapper.MAPPER.toDto(trip);

            // don't include private items of other members
            for (var member : res.getMembers()) {
                if (!Objects.equals(member.getUserProfileId(), userId)) {
                    member.setItems(member.getItems().stream().filter(item -> !item.isPrivate()).collect(Collectors.toList()));
                }
            }
            return res;
        } else {
            throw new AuthException("User not authorized to read this item.");
        }
    }

    public TripDto toDto(Trip trip) {
        return Mapper.MAPPER.toDto(entityManager.find(Trip.class, trip.getId()));
    }

    // Throws AuthException if user is not an owner of the trip
    private void checkTripOwnership(String userId, UUID tripId) throws AuthException {
        UserProfile userProfile = entityManager.find(UserProfile.class, userId);
        boolean isOwner = false;
        for (var m : userProfile.getMembers()) {
            if (m.getRole().equals(MemberRole.admin.name()) && m.getTrip().getId().equals(tripId)) {
                isOwner = true;
                break;
            }
        }
        if (!isOwner) throw new AuthException("User not authorized to edit this item.");
    }
}
