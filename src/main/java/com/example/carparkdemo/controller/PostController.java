package com.example.carparkdemo.controller;

import com.example.carparkdemo.entities.*;
import com.example.carparkdemo.service.HR.IHRService;
import com.example.carparkdemo.service.car.ICarService;
import com.example.carparkdemo.service.parkinglot.IParkingService;
import com.example.carparkdemo.service.ticket.ITicketService;
import com.example.carparkdemo.service.trip.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {
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

    @PostMapping("/employee")
    public String addEmployee(@RequestBody Employee employee) {
        HRService.addEmployee(employee);
        return "addEmployee";
    }

    @PostMapping("/trip")
    public String addTrip(@RequestBody Trip trip) {
        tripService.addTrip(trip);
        return "Trip added";
    }

    @PostMapping("/ticket")
    public String addTicket(@RequestBody Ticket ticket) {
        ticketService.addTicket(ticket);
        return "Ticket added";
    }

    @PostMapping("/car")
    public String addCar(@RequestBody Car car) {
        carService.addCar(car);
        return "Car added";
    }

    @PostMapping("/parkingLot")
    public String addParkingLot(@RequestBody ParkingLot parkingLot) {
        parkingLotService.addParkingLot(parkingLot);
        return "Parking Lot added";
    }
}
