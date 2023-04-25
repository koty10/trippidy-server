package cz.cvut.fel.trippidy.service;

import cz.cvut.fel.trippidy.dto.TripDto;
import cz.cvut.fel.trippidy.entity.Member;
import cz.cvut.fel.trippidy.entity.Trip;
import cz.cvut.fel.trippidy.entity.UserProfile;
import cz.cvut.fel.trippidy.entity.*;
import cz.cvut.fel.trippidy.enums.MemberRole;
import cz.cvut.fel.trippidy.mappers.Mapper;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.auth.message.AuthException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

//@ApplicationScoped
@Stateless
public class TripService {

    @PersistenceContext
    EntityManager entityManager;

    public List<TripDto> findTrips(String userId) {
        return entityManager.createNamedQuery(Trip.FIND_BY_USER_PROFILE_ID, Trip.class)
                .setParameter("userId", userId)
                .getResultStream()
                .map(Mapper.MAPPER::toDto)
                .collect(Collectors.toList());
    }

    // TODO it does not include userProfileFirstname etc in the response - maybe i have to load it somehow
    public TripDto createTrip(String userId, TripDto tripDto) {
        //return null;
        UserProfile userProfile = entityManager.createNamedQuery(UserProfile.FIND_BY_ID, UserProfile.class)
                .setParameter("userId", userId)
                .getSingleResult();

        var newTrip = Mapper.MAPPER.toEntity(tripDto);
        entityManager.persist(newTrip);

        return Mapper.MAPPER.toDto(newTrip);

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

    public TripDto findTripById(String id) {
        return Mapper.MAPPER.toDto(entityManager.find(Trip.class, id));
    }

    public TripDto deleteTrip(String userId, String id) throws AuthException {
        UserProfile userProfile = entityManager.find(UserProfile.class, userId);
        boolean isOwner = false;
        for (var m : userProfile.getMembers()) {
            var u = m.getUserProfile();
            if (u.getId().equals(userId) && m.getRole().equals(MemberRole.admin.name())) isOwner = true;
        }
        if (!isOwner) throw new AuthException("User not authorized to edit this item.");

        var trip = entityManager.find(Trip.class, id);
        trip.setDeleted(true);
        entityManager.persist(trip);
        return Mapper.MAPPER.toDto(trip);
    }
}
