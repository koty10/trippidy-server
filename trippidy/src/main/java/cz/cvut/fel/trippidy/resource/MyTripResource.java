package cz.cvut.fel.trippidy.resource;

import cz.cvut.fel.trippidy.dto.TripDto;
import cz.cvut.fel.trippidy.mappers.Mapper;
import cz.cvut.fel.trippidy.service.TripService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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

    // TODO use those DTOs
    @GET
    public Collection<TripDto> trips() {
        return Mapper.MAPPER.toDto(tripService.findTrips(securityContext.getUserPrincipal().getName()));//.stream().map(Mapper.MAPPER::toDto).collect(Collectors.toList());
    }

    @POST
    public TripDto createTrip(TripDto tripDto) {
        return Mapper.MAPPER.toDto(tripService.createTrip(securityContext.getUserPrincipal().getName(), tripDto.getName(), tripDto.getDateFrom(), tripDto.getDateTo()));
    }
}