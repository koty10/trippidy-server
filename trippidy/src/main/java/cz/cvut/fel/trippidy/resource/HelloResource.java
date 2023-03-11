package cz.cvut.fel.trippidy.resource;

import cz.cvut.fel.trippidy.service.TripService;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {

    @EJB
    TripService tripService;

    @GET
    @Produces("text/plain")
    public String hello() {
        return tripService.findTrip(1).getName();
        //return "Hello, World2!";
    }
}