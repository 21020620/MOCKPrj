package com.example.carparkdemo.service.trip;

import com.example.carparkdemo.entities.Trip;
import com.example.carparkdemo.repository.TripRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService implements ITripService{
    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public String getAllTrips() {
        List<Trip> trips = tripRepository.findAll();
        StringBuilder sb = new StringBuilder();
        trips.forEach(trip -> sb.append(trip.toString()).append("\n"));
        return sb.toString();
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    public String deleteTrip(Long id) {
        boolean exists = tripRepository.existsById(id);
        if (!exists) {
            return "Trip with id " + id + " does not exist";
        }
        tripRepository.deleteById(id);
        return "Trip removed: " + id;
    }
}
