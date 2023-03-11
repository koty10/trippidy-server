package cz.cvut.fel.trippidy.service;

import cz.cvut.fel.trippidy.model.Trip;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TripService {

    // connection to the database
    @PersistenceContext
    EntityManager em;

    public Trip findTrip(Integer id) {
        //em.getEntityManagerFactory().getCache().evictAll();
        return em.find(Trip.class, id);
    }
}
