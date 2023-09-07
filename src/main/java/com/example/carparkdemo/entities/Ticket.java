package com.example.carparkdemo.entities;

import jakarta.persistence.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Time;

@Entity
@Component
@Table(name = "ticket")
@Scope("prototype")
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "booking_time")
    private Time bookingTime;
    @Column(name = "customer_name")
    private String customerName;

    @OneToOne
    @JoinColumn(name = "license_plate")
    private Car licensePlate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "trip_id")
    private Trip trip;

    public Ticket() {
    }

    public Ticket(Long id, Time bookingTime, String customerName, Car licensePlate, Trip trip) {
        this.id = id;
        this.bookingTime = bookingTime;
        this.customerName = customerName;
        this.licensePlate = licensePlate;
        this.trip = trip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Time bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Car getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(Car licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", bookingTime=" + bookingTime +
                ", customerName='" + customerName + '\'' +
                ", licensePlate=" + licensePlate +
                ", trip=" + trip +
                '}';
    }
}
