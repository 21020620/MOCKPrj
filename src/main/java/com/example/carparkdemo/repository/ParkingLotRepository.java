package com.example.carparkdemo.repository;

import com.example.carparkdemo.entities.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
}
