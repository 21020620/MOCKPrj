package com.example.carparkdemo.entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "car")
@Component
public class Car {
    @Id
    private String licensePlate;
    @Column(name = "type")
    private String type;
    @Column(name = "color")
    private String color;
    @Column(name = "company")
    private String company;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "park_id")
    private ParkingLot parkingLot;


    public Car(String licensePlate, String type, String color, String company, ParkingLot parkingLot) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.color = color;
        this.company = company;
        this.parkingLot = parkingLot;
    }

    public Car() {
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", company='" + company + '\'' +
                ", parkingLot=" + parkingLot.getId() +
                '}';
    }
}
