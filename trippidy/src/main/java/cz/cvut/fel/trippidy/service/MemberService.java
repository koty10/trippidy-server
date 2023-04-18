package cz.cvut.fel.trippidy.service;

import cz.cvut.fel.trippidy.dto.MemberDto;
import cz.cvut.fel.trippidy.entity.Member;
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
}
