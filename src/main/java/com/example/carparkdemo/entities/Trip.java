package com.example.carparkdemo.entities;

import jakarta.persistence.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "trip")
@Component
@Scope("prototype")
public class Trip {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "Booked ticket number")
    private int bookedTicketNumber;
    @Column (name = "Car type")
    private String carType;
    @Column (name = "Departure date")
    private Date dapartureDate;
    @Column (name = "Departure time")
    private Time departureTime;
    @Column (name = "Destination")
    private String destination;
    @Column (name = "Driver")
    private String driver;
    @Column (name = "Maximum online ticket number")
    private int maximumOnlineTicketNumber;

    public Trip() {
    }

    public Trip(Long id, int bookedTicketNumber, String carType, Date dapartureDate,
                Time departureTime, String destination, String driver, int maximumOnlineTicketNumber) {
        this.id = id;
        this.bookedTicketNumber = bookedTicketNumber;
        this.carType = carType;
        this.dapartureDate = dapartureDate;
        this.departureTime = departureTime;
        this.destination = destination;
        this.driver = driver;
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBookedTicketNumber() {
        return bookedTicketNumber;
    }

    public void setBookedTicketNumber(int bookedTicketNumber) {
        this.bookedTicketNumber = bookedTicketNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Date getDapartureDate() {
        return dapartureDate;
    }

    public void setDapartureDate(Date dapartureDate) {
        this.dapartureDate = dapartureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getMaximumOnlineTicketNumber() {
        return maximumOnlineTicketNumber;
    }

    public void setMaximumOnlineTicketNumber(int maximumOnlineTicketNumber) {
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", bookedTicketNumber=" + bookedTicketNumber +
                ", carType='" + carType + '\'' +
                ", dapartureDate=" + dapartureDate +
                ", departureTime=" + departureTime +
                ", destination='" + destination + '\'' +
                ", driver='" + driver + '\'' +
                ", maximumOnlineTicketNumber=" + maximumOnlineTicketNumber +
                '}';
    }
}
