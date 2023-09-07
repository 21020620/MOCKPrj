package com.example.carparkdemo.service.car;

import com.example.carparkdemo.entities.Car;

public interface ICarService {
    String getAllCars();
    Car addCar(Car car);
    String deleteCar(String licensePlate);
    Car getCarById(String licensePlate);
}
