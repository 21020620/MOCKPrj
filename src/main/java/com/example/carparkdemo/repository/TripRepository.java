package com.example.carparkdemo.repository;

import com.example.carparkdemo.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
