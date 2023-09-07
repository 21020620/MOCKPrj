package com.example.carparkdemo.controller;

import com.example.carparkdemo.entities.Employee;
import com.example.carparkdemo.service.HR.IHRService;
import com.example.carparkdemo.service.car.ICarService;
import com.example.carparkdemo.service.parkinglot.IParkingService;
import com.example.carparkdemo.service.ticket.ITicketService;
import com.example.carparkdemo.service.trip.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/get")
@Scope("request")
public class GetController {
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

    @GetMapping("/employee")
    public String getAllEmployee() {
        return HRService.getAllEmployee();
    }

    @GetMapping("/employeePage")
    public List<Employee> getAllEmployee(@RequestParam(defaultValue = "0") Integer page) {
        return HRService.getAllEmployeeByPage(page, 2);
    }

    @GetMapping("/car")
    public String getAllCar() {
        return carService.getAllCars();
    }

    @GetMapping("/trip")
    public String getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/ticket")
    public String getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/parkingLot")
    public String getAllParkingLots() {
        return parkingLotService.getAllParkingLots();
    }

    @GetMapping("/employee/{id}")
    public String getEmployeeById(@PathVariable Long id) {
        return HRService.getEmployeeById(id).toString();
    }

    @GetMapping("/car/{licensePlate}")
    public String getCarById(@PathVariable String licensePlate) {
        return carService.getCarById(licensePlate).toString();
    }

    @GetMapping("/trip/{id}")
    public String getTripById(@PathVariable Long id) {
        return tripService.getTripById(id).toString();
    }

    @GetMapping("/ticket/{id}")
    public String getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id).toString();
    }

    @GetMapping("/parkinglot/{id}")
    public String getParkingLotById(@PathVariable Long id) {
        return parkingLotService.getParkingLotById(id).toString();
    }
}
