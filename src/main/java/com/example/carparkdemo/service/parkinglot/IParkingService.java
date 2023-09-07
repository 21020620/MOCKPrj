package com.example.carparkdemo.service.parkinglot;

import com.example.carparkdemo.entities.ParkingLot;

public interface IParkingService {
    String getAllParkingLots();
    ParkingLot getParkingLotById(Long id);
    ParkingLot addParkingLot(ParkingLot parkingLot);
    String deleteParkingLot(Long id);
}
