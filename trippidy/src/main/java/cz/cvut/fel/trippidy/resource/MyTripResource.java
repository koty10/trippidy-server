package cz.cvut.fel.trippidy.resource;

import cz.cvut.fel.trippidy.model.Trip;
import cz.cvut.fel.trippidy.service.TripService;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/my/trip")
@RequestScoped
@RolesAllowed({"user"})
public class MyTripResource {
    @Inject
    TripService tripService;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces("application/json")
    public List<Trip> trips() {
        return tripService.findTrips(securityContext.getUserPrincipal().getName());
    }
}