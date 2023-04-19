package cz.cvut.fel.trippidy.resource;

import cz.cvut.fel.trippidy.dto.TripDto;
import cz.cvut.fel.trippidy.dto.UserProfileDto;
import cz.cvut.fel.trippidy.mappers.Mapper;
import cz.cvut.fel.trippidy.service.TripService;
import cz.cvut.fel.trippidy.service.UserProfileService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.Collection;

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

    @GET
    @Path("{query}")
    public Collection<UserProfileDto> userProfile(@PathParam("query") String query) {
        return userProfileService.findUserProfileByQuery(securityContext.getUserPrincipal().getName(), query);
    }
}