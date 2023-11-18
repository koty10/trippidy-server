package cz.cvut.fel.trippidy.service;

import cz.cvut.fel.trippidy.dto.ItemDto;
import cz.cvut.fel.trippidy.dto.MemberDto;
import cz.cvut.fel.trippidy.entity.*;
import cz.cvut.fel.trippidy.mappers.Mapper;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.security.auth.message.AuthException;

import java.util.UUID;

@Stateless
public class MemberService {

    @PersistenceContext
    EntityManager entityManager;

    public Member updateMember(String userId, MemberDto memberDto) throws AuthException {
        var member = entityManager.find(Member.class, memberDto.getId());
        if (!member.getUserProfile().getId().equals(userId)) throw new AuthException("User not authorized to edit this member.");
        member.setAccepted(memberDto.getAccepted());
        member.setRole(memberDto.getRole());
        //entityManager.persist(member);
        return member;
    }

    public Member createMember(MemberDto memberDto) {
        Member member = Mapper.MAPPER.toEntity(memberDto);

        var trip = entityManager.find(Trip.class, member.getTrip().getId());
        var userProfile = entityManager.find(UserProfile.class, member.getUserProfile().getId());
        // TODO it might be a problem
        //trip.getMembers().add(member);
        //userProfile.getMembers().add(member);
        member.setTrip(trip);
        member.setUserProfile(userProfile);
        entityManager.persist(member);
        return member;
        //return Mapper.MAPPER.toDto(member);
    }

    public MemberDto toDto(Member member) {
        return Mapper.MAPPER.toDto(entityManager.find(Member.class, member.getId()));
    }
}
