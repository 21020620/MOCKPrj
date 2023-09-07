package com.example.carparkdemo.controller;

import com.example.carparkdemo.service.HR.HRService;
import com.example.carparkdemo.service.HR.IHRService;
import com.example.carparkdemo.service.car.ICarService;
import com.example.carparkdemo.service.parkinglot.IParkingService;
import com.example.carparkdemo.service.ticket.ITicketService;
import com.example.carparkdemo.service.trip.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/put")
public class PutController {
    @Autowired
    private IHRService HRService;

    @PutMapping("/employee/{id}")
    public String updateEmployee(@PathVariable Long id) {
        HRService.editEmployee(id);
        return "updateEmployee";
    }


}
