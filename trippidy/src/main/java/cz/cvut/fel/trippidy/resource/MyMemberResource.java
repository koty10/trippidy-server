package cz.cvut.fel.trippidy.resource;

import cz.cvut.fel.trippidy.dto.ItemDto;
import cz.cvut.fel.trippidy.dto.MemberDto;
import cz.cvut.fel.trippidy.service.ItemService;
import cz.cvut.fel.trippidy.service.MemberService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/v1/my/member")
@RequestScoped
@RolesAllowed({"user"})
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyMemberResource {
    @EJB
    MemberService memberService;

    @Context
    SecurityContext securityContext;

    @PUT
    public MemberDto updateMember(@Context HttpServletRequest request, MemberDto memberDto) throws AuthException {
        return memberService.updateMember(securityContext.getUserPrincipal().getName(), memberDto);
    }
}