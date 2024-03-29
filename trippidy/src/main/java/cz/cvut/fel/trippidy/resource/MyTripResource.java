package cz.cvut.fel.trippidy.resource;

import cz.cvut.fel.trippidy.dto.TripDto;
import cz.cvut.fel.trippidy.mappers.Mapper;
import cz.cvut.fel.trippidy.service.TripService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.security.auth.message.AuthException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import java.util.Collection;
import java.util.UUID;

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

    @GET
    @Path("{id}")
    public TripDto trip(@PathParam("id") String id) throws AuthException {
        return tripService.findTrip(securityContext.getUserPrincipal().getName(), UUID.fromString(id));
    }

    @POST
    public TripDto createTrip(TripDto tripDto) {
        var trip = tripService.createTrip(tripDto);
        return tripService.toDto(trip);
    }

    @DELETE
    @Path("{id}")
    public TripDto deleteTrip(@PathParam("id") String id) throws AuthException {
        var trip = tripService.deleteTrip(securityContext.getUserPrincipal().getName(), UUID.fromString(id));
        return tripService.toDto(trip);
    }
}
