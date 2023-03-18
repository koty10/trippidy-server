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
import java.util.List;

@Stateless
public class UserProfileService {

    @PersistenceContext
    EntityManager entityManager;

    public UserProfileDto findUserProfile(String userId) {
        return Mapper.MAPPER.toDto(entityManager.createNamedQuery(UserProfile.FIND_BY_ID, UserProfile.class)
                .setParameter("userId", userId)
                .getSingleResult());
    }
}
