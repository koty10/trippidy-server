package cz.cvut.fel.trippidy.service;

import cz.cvut.fel.trippidy.dto.ItemDto;
import cz.cvut.fel.trippidy.dto.MemberDto;
import cz.cvut.fel.trippidy.entity.*;
import cz.cvut.fel.trippidy.mappers.Mapper;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.auth.message.AuthException;

@Stateless
public class MemberService {

    @PersistenceContext
    EntityManager entityManager;

    public MemberDto updateMember(String userId, MemberDto memberDto) throws AuthException {
        var member = entityManager.find(Member.class, memberDto.getId());
        if (!member.getUserProfile().getId().equals(userId)) throw new AuthException("User not authorized to edit this member.");
        member.setAccepted(memberDto.getAccepted());
        member.setRole(memberDto.getRole());
        entityManager.persist(member);
        return Mapper.MAPPER.toDto(member);
    }

    public MemberDto createMember(String userId, MemberDto memberDto) throws Exception { //todo remove userId
        if (entityManager.find(Member.class, memberDto.getId()) != null) throw new Exception("Element already exists");

        Member member = Mapper.MAPPER.toEntity(memberDto);
        entityManager.persist(member);

        var trip = entityManager.find(Trip.class, member.getTrip().getId());
        var userProfile = entityManager.find(UserProfile.class, member.getUserProfile().getId());
        trip.getMembers().add(member);
        userProfile.getMembers().add(member);
        entityManager.persist(trip);
        entityManager.persist(userProfile);
        // FIXME I have to load full member object here but probably this is not the best approach
        member.setUserProfile(userProfile);
        return Mapper.MAPPER.toDto(member);
    }
}
