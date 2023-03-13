package cz.cvut.fel.trippidy.service;

import com.speedment.jpastreamer.application.JPAStreamer;
import cz.cvut.fel.trippidy.model.Trip;
import cz.cvut.fel.trippidy.model.Trip$;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TripService {

    JPAStreamer jpaStreamer;

    public TripService() {
        jpaStreamer = JPAStreamer.of("test");
    }

    public List<Trip> findTrips() {
        return jpaStreamer.stream(Trip.class)
                .filter(Trip$.name.startsWith("A"))
                .collect(Collectors.toList());
    }
}
