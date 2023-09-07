package com.example.carparkdemo.service.trip;

import com.example.carparkdemo.entities.Trip;

public interface ITripService {
    String getAllTrips();
    Trip getTripById(Long id);
    Trip addTrip(Trip trip);
    String deleteTrip(Long id);
}
