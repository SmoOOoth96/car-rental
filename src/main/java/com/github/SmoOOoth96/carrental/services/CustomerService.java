package com.github.SmoOOoth96.carrental.services;

import com.github.SmoOOoth96.carrental.models.Customer;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);

    Customer show(int id);

    List<Customer> findAllCustomers();

    void delete(int id);
}
