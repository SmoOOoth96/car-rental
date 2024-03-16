package com.github.SmoOOoth96.carrental.services;

import com.github.SmoOOoth96.carrental.models.Car;
import com.github.SmoOOoth96.carrental.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car show(int id) {
        return carRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Car not found with id: " + id));
    }

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public void delete(int id) {
        carRepository.deleteById(id);
    }
}
