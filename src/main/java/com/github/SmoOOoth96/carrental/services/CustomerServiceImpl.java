package com.github.SmoOOoth96.carrental.services;

import com.github.SmoOOoth96.carrental.models.Customer;
import com.github.SmoOOoth96.carrental.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer show(int id) {
        return customerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Customer not found with id: " + id));
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }
}
