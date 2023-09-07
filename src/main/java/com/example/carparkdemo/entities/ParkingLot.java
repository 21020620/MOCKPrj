package com.example.carparkdemo.entities;

import jakarta.persistence.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "parking_lot")
@Component
@Scope("prototype")
public class ParkingLot {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "park_area")
    private long parkArea;
    @Column(name = "name")
    private String parkName;
    @Column(name = "place")
    private String parkPlace;
    @Column(name = "price")
    private long parkPrice;
    @Column(name = "status")
    private String parkStatus;

    public ParkingLot() {
    }

    public ParkingLot(Long id, long parkArea, String parkName, String parkPlace, long parkPrice,
                      String parkStatus) {
        this.id = id;
        this.parkArea = parkArea;
        this.parkName = parkName;
        this.parkPlace = parkPlace;
        this.parkPrice = parkPrice;
        this.parkStatus = parkStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getParkArea() {
        return parkArea;
    }

    public void setParkArea(long parkArea) {
        this.parkArea = parkArea;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkPlace() {
        return parkPlace;
    }

    public void setParkPlace(String parkPlace) {
        this.parkPlace = parkPlace;
    }

    public long getParkPrice() {
        return parkPrice;
    }

    public void setParkPrice(long parkPrice) {
        this.parkPrice = parkPrice;
    }

    public String getParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(String parkStatus) {
        this.parkStatus = parkStatus;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "id=" + id +
                ", Area=" + parkArea +
                ", Name='" + parkName + '\'' +
                ", Place='" + parkPlace + '\'' +
                ", Price=" + parkPrice +
                ", Status='" + parkStatus + '\'' +
                '}';
    }
}
