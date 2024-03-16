package com.github.SmoOOoth96.carrental.services;

import com.github.SmoOOoth96.carrental.models.Car;
import com.github.SmoOOoth96.carrental.repositories.CarRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CarServiceImplTest {
    private final CarRepository carRepository = Mockito.mock(CarRepository.class);
    private final CarServiceImpl carService = new CarServiceImpl(carRepository);

    @Test
    @DisplayName("Test showCarById")
    public void testShowCar(){
        int carId = 1;
        Car car = new Car();
        car.setId(carId);
        car.setRents(List.of());
        when(carRepository.findById(carId)).thenReturn(Optional.of(car));
        Car carDTO = carService.show(carId);
        assertEquals(carId, carDTO.getId());
        verify(carRepository, times(1)).findById(carId);
    }

    @Test
    @DisplayName("Test findAllCars")
    public void testFindAllCars(){
        List<Car> cars = new ArrayList<>();
        Car car = new Car();
        car.setId(1);
        car.setRents(List.of());
        cars.add(car);
        when(carRepository.findAll()).thenReturn(cars);
        Collection<Car> carsDTO = carService.findAllCars();
        assertEquals(cars.size(), carsDTO.size());
        verify(carRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Test saveCar")
    public void testSaveCar(){
        Car car = new Car();
        carService.save(car);
        verify(carRepository, times(1))
                .save(any(Car.class));
    }

    @Test
    @DisplayName("Test deleteCar")
    public void testDeleteCar(){
        int carId = 1;
        carService.delete(carId);
        verify(carRepository, times(1))
                .deleteById(carId);
    }
}
