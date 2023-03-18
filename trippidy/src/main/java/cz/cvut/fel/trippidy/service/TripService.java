package cz.cvut.fel.trippidy.service;

import cz.cvut.fel.trippidy.dto.TripDto;
import cz.cvut.fel.trippidy.entity.Member;
import cz.cvut.fel.trippidy.entity.Trip;
import cz.cvut.fel.trippidy.entity.UserProfile;
import cz.cvut.fel.trippidy.entity.*;
import cz.cvut.fel.trippidy.mappers.Mapper;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    public TripDto createTrip(String userId, String name, LocalDateTime dateFrom, LocalDateTime dateTo) {
        //return null;
        UserProfile userProfile = entityManager.createNamedQuery(UserProfile.FIND_BY_ID, UserProfile.class)
                .setParameter("userId", userId)
                .getSingleResult();

        Member member = new Member();
        member.setAccepted(true);
        member.setRole("admin");
        member.setUserProfile(userProfile);

        Trip trip = new Trip();
        trip.setName(name);
        trip.setDateFrom(dateFrom);
        trip.setDateTo(dateTo);
        trip.addMember(member);
        member.setTrip(trip);

        entityManager.persist(trip);
        //entityManager.persist(member);
        return Mapper.MAPPER.toDto(trip);
    }
}
