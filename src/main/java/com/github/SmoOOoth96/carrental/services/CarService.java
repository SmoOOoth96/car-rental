package com.github.SmoOOoth96.carrental.services;

import com.github.SmoOOoth96.carrental.models.Car;

import java.util.List;

public interface CarService {
    void save(Car car);

    Car show(int id);

    List<Car> findAllCars();

    void delete(int id);
}
