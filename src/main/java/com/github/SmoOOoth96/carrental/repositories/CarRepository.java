package com.github.SmoOOoth96.carrental.repositories;

import com.github.SmoOOoth96.carrental.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
