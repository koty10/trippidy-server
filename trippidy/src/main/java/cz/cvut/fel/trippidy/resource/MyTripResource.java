package cz.cvut.fel.trippidy.resource;

import cz.cvut.fel.trippidy.dto.TripDto;
import cz.cvut.fel.trippidy.mappers.Mapper;
import cz.cvut.fel.trippidy.service.TripService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.security.auth.message.AuthException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.Collection;

@Path("/v1/my/trip")
@RequestScoped
@RolesAllowed({"user"})
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyTripResource {
    @EJB
    TripService tripService;

    @Context
    SecurityContext securityContext;

    @GET
    public Collection<TripDto> trips() {
        return tripService.findTrips(securityContext.getUserPrincipal().getName());
    }

    @POST
    public TripDto createTrip(TripDto tripDto) {
        var trip = tripService.createTrip(securityContext.getUserPrincipal().getName(), tripDto);
        return tripService.findTripById(trip.getId());
    }

    @DELETE
    @Path("{id}")
    public TripDto deleteTrip(@PathParam("id") String id) throws AuthException {
        return tripService.deleteTrip(securityContext.getUserPrincipal().getName(), id);
    }
}