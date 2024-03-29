package cz.cvut.fel.trippidy.resource;

import cz.cvut.fel.trippidy.dto.MemberDto;
import cz.cvut.fel.trippidy.dto.TripDto;
import cz.cvut.fel.trippidy.dto.UserProfileDto;
import cz.cvut.fel.trippidy.mappers.Mapper;
import cz.cvut.fel.trippidy.service.TripService;
import cz.cvut.fel.trippidy.service.UserProfileService;
import liquibase.datatype.core.UUIDType;
import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import java.util.Collection;
import java.util.UUID;

@Path("/v1/my/userProfile")
@RequestScoped
@RolesAllowed({"user"})
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyUserProfileResource {
    @EJB
    UserProfileService userProfileService;

    @Context
    SecurityContext securityContext;

    @GET
    public UserProfileDto userProfile() {
        return userProfileService.findUserProfile(securityContext.getUserPrincipal().getName());
    }

    @PUT
    public UserProfileDto updateUserProfile(UserProfileDto userProfileDto) throws AuthException {
        var userProfile = userProfileService.updateUserProfile(securityContext.getUserPrincipal().getName(), userProfileDto);
        return userProfileService.toDto(userProfile);
    }

    @GET
    @Path("{query}")
    public Collection<UserProfileDto> userProfile(@PathParam("query") String query, @QueryParam("tripId") String tripId) {
        return userProfileService.findUserProfileByQuery(securityContext.getUserPrincipal().getName(), query, UUID.fromString(tripId));
    }
}
