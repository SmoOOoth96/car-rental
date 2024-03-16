package com.github.SmoOOoth96.carrental.services;

import com.github.SmoOOoth96.carrental.models.Customer;
import com.github.SmoOOoth96.carrental.models.Rent;

import java.util.List;

public interface RentService {

    void save(Rent rent);

    Rent show(int id);

    List<Rent> findAllRentsBy(Customer customer);

    List<Rent> findAllRents();
}
