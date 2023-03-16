package cz.cvut.fel.trippidy.service;

import cz.cvut.fel.trippidy.entity.Member;
import cz.cvut.fel.trippidy.entity.Trip;
import cz.cvut.fel.trippidy.entity.UserProfile;
import cz.cvut.fel.trippidy.entity.*;

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

    public List<Trip> findTrips(String userId) {
        return entityManager.createNamedQuery(Trip.FIND_BY_USER_PROFILE_ID, Trip.class)
                .setParameter("userId", userId)
                .getResultList();

//        return jpaStreamer.stream(UserProfile.class)
//                .filter(UserProfile$.id.equal(userId))
//                .findFirst()
//                .orElseThrow()
//                .getMembers()
//                .stream()
//                .map(Member::getTrip)
//                .collect(Collectors.toList());
    }

    public Trip createTrip(String userId, String name, LocalDateTime dateFrom, LocalDateTime dateTo) {
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
        return trip;
    }
}
