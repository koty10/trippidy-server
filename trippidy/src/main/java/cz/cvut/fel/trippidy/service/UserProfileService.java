package cz.cvut.fel.trippidy.service;

import cz.cvut.fel.trippidy.dto.UserProfileDto;
import cz.cvut.fel.trippidy.entity.Trip;
import cz.cvut.fel.trippidy.entity.UserProfile;
import cz.cvut.fel.trippidy.mappers.Mapper;
import cz.cvut.fel.trippidy.utility.StringUtility;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.iban4j.CountryCode;
import org.iban4j.Iban;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.security.auth.message.AuthException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class UserProfileService {

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    JsonWebToken request;

    public UserProfileDto findUserProfile(String userId) {
        try {
            var userProfile = entityManager.find(UserProfile.class, userId);
            if (userProfile == null) throw new NoResultException("User does not exist");
            return Mapper.MAPPER.toDto(userProfile);
        } catch (NoResultException exception) {
            UserProfile newUserProfile = new UserProfile();
            newUserProfile.setId(userId);
            newUserProfile.setFirstname("");
            newUserProfile.setLastname("");
            newUserProfile.setBankAccountNumber("");
            newUserProfile.setIban("");
            newUserProfile.setImage(request.getClaim("picture"));
            newUserProfile.setEmail(request.getClaim("email"));
            entityManager.persist(newUserProfile);
            return Mapper.MAPPER.toDto(newUserProfile);
        }
    }

    public Collection<UserProfileDto> findUserProfileByQuery(String userId, String query, UUID tripId) {
        var trip = entityManager.find(Trip.class, tripId);
        var userProfiles = entityManager.createNamedQuery(UserProfile.FIND_BY_QUERY, UserProfile.class)
                .setParameter("query", "%" + query + "%")
                .setParameter("userId", userId)
                .getResultStream()
                .filter(userProfile -> userProfile.getMembers().stream().noneMatch(trip.getMembers()::contains))
                .collect(Collectors.toList());
        return userProfiles.stream().map(Mapper.MAPPER::toDto).collect(Collectors.toList());
    }

    public UserProfile updateUserProfile(String userId, UserProfileDto userProfileDto) throws AuthException {
        var userProfile = entityManager.find(UserProfile.class, userProfileDto.getId());
        if (!userProfile.getId().equals(userId)) throw new AuthException("User not authorized to edit this userProfile.");
        userProfile.setFirstname(userProfileDto.getFirstname());
        userProfile.setLastname(userProfileDto.getLastname());
        userProfile.setBankAccountNumber(userProfileDto.getBankAccountNumber());

        if (!userProfileDto.getBankAccountNumber().isEmpty()) {
            var bankAccountNumberArray = userProfileDto.getBankAccountNumber().split("/");
            var bankAccountNumber = bankAccountNumberArray[0];
            var bankCode = bankAccountNumberArray[1];

            // remove hyphens and add 0 from left to get 16 characters long bank account number
            bankAccountNumber = StringUtility.normalizeString(bankAccountNumber);

            Iban iban = new Iban.Builder()
                    .countryCode(CountryCode.CZ)
                    .bankCode(bankCode)
                    .accountNumber(bankAccountNumber)
                    .build();
            userProfile.setIban(iban.toString());
            userProfile.setBankAccountNumber(userProfileDto.getBankAccountNumber());
        } else {
            // user can remove his bank account number
            userProfile.setBankAccountNumber(userProfileDto.getBankAccountNumber());
        }

        return userProfile;
    }

    public UserProfileDto toDto(UserProfile userProfile) {
        return Mapper.MAPPER.toDto(userProfile);
    }
}
