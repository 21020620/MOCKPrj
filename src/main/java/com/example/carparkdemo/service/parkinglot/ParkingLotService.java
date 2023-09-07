package com.example.carparkdemo.service.parkinglot;

import com.example.carparkdemo.entities.ParkingLot;
import com.example.carparkdemo.repository.ParkingLotRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ParkingLotService implements IParkingService{
    private final ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public String getAllParkingLots() {
        List<ParkingLot> parkingLots = parkingLotRepository.findAll();
        StringBuilder sb = new StringBuilder();
        parkingLots.forEach(parkingLot -> sb.append(parkingLot.toString()).append("\n"));
        return sb.toString();
    }

    public ParkingLot getParkingLotById(Long id) {
        return parkingLotRepository.findById(id).orElse(null);
    }
    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    public ParkingLot addParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    public String deleteParkingLot(Long id) {
        boolean exists = parkingLotRepository.existsById(id);
        if (!exists) {
            return "ParkingLot with id " + id + " does not exist";
        }
        parkingLotRepository.deleteById(id);
        return "ParkingLot removed: " + id;
    }


}
