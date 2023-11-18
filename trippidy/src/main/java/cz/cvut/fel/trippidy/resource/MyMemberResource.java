package cz.cvut.fel.trippidy.resource;

import cz.cvut.fel.trippidy.dto.ItemDto;
import cz.cvut.fel.trippidy.dto.MemberDto;
import cz.cvut.fel.trippidy.service.ItemService;
import cz.cvut.fel.trippidy.service.MemberService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

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

    @POST
    public Response createMember(@Context HttpServletRequest request, MemberDto memberDto) throws Exception {
        var member = memberService.createMember(securityContext.getUserPrincipal().getName(), memberDto);
        return Response.ok(memberService.toDto(member))
                //.header("location", "")
                .build();
    }
}
