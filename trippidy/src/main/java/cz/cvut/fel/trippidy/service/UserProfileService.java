package cz.cvut.fel.trippidy.service;

import cz.cvut.fel.trippidy.dto.UserProfileDto;
import cz.cvut.fel.trippidy.entity.Member;
import cz.cvut.fel.trippidy.entity.Trip;
import cz.cvut.fel.trippidy.entity.UserProfile;
import cz.cvut.fel.trippidy.mappers.Mapper;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
public class UserProfileService {

    @PersistenceContext
    EntityManager entityManager;

    public UserProfileDto findUserProfile(String userId) {
        try {
            return Mapper.MAPPER.toDto(entityManager.createNamedQuery(UserProfile.FIND_BY_ID, UserProfile.class)
                    .setParameter("userId", userId)
                    .getSingleResult());
        } catch (NoSuchElementException exception) {
            UserProfile newUserProfile = new UserProfile();
            newUserProfile.setId(userId);
            newUserProfile.setFirstname("autoJmeno");
            newUserProfile.setLastname("autoPrijmeni");
            newUserProfile.setImage("https://www.gravatar.com/avatar/00000000000000000000000000000000?d=retro&f=y");
            entityManager.persist(newUserProfile);
            return Mapper.MAPPER.toDto(newUserProfile);
        }
    }

    public Collection<UserProfileDto> findUserProfileByQuery(String userId, String query, String tripId) {
        var trip = entityManager.find(Trip.class, tripId);
        return Mapper.MAPPER.toDto1(entityManager.createNamedQuery(UserProfile.FIND_BY_QUERY, UserProfile.class)
                .setParameter("query", "%" + query + "%")
                .setParameter("userId", userId)
                .getResultStream()
                .filter(userProfile -> userProfile.getMembers().stream().noneMatch(trip.getMembers()::contains))
                .collect(Collectors.toList())
        );
    }
}
