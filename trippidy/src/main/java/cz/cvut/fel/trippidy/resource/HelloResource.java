package cz.cvut.fel.trippidy.resource;

import cz.cvut.fel.trippidy.model.Trip;
import cz.cvut.fel.trippidy.service.TripService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.stream.Collectors;

@Path("/hello-world")
public class HelloResource {

    @Inject
    TripService tripService;

    @GET
    @Produces("text/plain")
    public String hello() {
        List<String> a = tripService.findTrips().stream().map(Trip::getName).collect(Collectors.toList());

        return a.toString();
    }
}