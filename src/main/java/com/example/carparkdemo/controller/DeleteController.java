package com.example.carparkdemo.controller;

import com.example.carparkdemo.service.HR.IHRService;
import com.example.carparkdemo.service.car.ICarService;
import com.example.carparkdemo.service.parkinglot.IParkingService;
import com.example.carparkdemo.service.ticket.ITicketService;
import com.example.carparkdemo.service.trip.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/delete")
public class DeleteController {
    @Autowired
    private ICarService carService;
    @Autowired
    private ITripService tripService;
    @Autowired
    private IHRService HRService;
    @Autowired
    private ITicketService ticketService;
    @Autowired
    private IParkingService parkingLotService;

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        HRService.deleteEmployee(id);
        return "deleteEmployee";
    }

    @DeleteMapping("/car/{id}")
    public String deleteCar(@PathVariable String licensePlate) {
        carService.deleteCar(licensePlate);
        return "deleteCar";
    }

    @DeleteMapping("/trip/{id}")
    public String deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return "deleteTrip";
    }

    @DeleteMapping("/ticket/{id}")
    public String deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return "deleteTicket";
    }

    @DeleteMapping("/parkingLot/{id}")
    public String deleteParkingLot(@PathVariable Long id) {
        parkingLotService.deleteParkingLot(id);
        return "deleteParkingLot";
    }
}
