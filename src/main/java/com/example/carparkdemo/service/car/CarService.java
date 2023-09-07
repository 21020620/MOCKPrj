package com.example.carparkdemo.service.car;

import com.example.carparkdemo.entities.Car;
import com.example.carparkdemo.repository.CarRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    public String getAllCars() {
        List<Car> cars = carRepository.findAll();
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> sb.append(car.toString()).append("\n"));
        return sb.toString();
    }

    @Transactional
    public Car getCarById(String licensePlate) {
        return carRepository.findById(licensePlate).orElse(null);
    }

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    public String deleteCar(String licensePlate) {
        boolean exists = carRepository.existsById(licensePlate);
        if (!exists) {
            return "Car with plate " + licensePlate + " does not exist";
        }
        carRepository.deleteById(licensePlate);
        return "Car removed: " + licensePlate;
    }
}
