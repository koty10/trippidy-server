package cz.cvut.fel.trippidy.service;

import com.speedment.jpastreamer.application.JPAStreamer;
import cz.cvut.fel.trippidy.model.*;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TripService {

    JPAStreamer jpaStreamer;

    public TripService() {
        jpaStreamer = JPAStreamer.of("trippidy");
    }

    public List<Trip> findTrips(String id) {
        return jpaStreamer.stream(UserProfile.class)
                .filter(UserProfile$.id.equal(id))
                .findFirst()
                .orElseThrow()
                .getMembers()
                .stream()
                .map(Member::getTrip)
                .collect(Collectors.toList());
    }
}
