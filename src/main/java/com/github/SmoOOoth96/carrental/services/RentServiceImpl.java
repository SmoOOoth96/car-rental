package com.github.SmoOOoth96.carrental.services;

import com.github.SmoOOoth96.carrental.models.Customer;
import com.github.SmoOOoth96.carrental.models.Rent;
import com.github.SmoOOoth96.carrental.repositories.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RentServiceImpl implements RentService{
    private final RentRepository rentRepository;

    @Autowired
    public RentServiceImpl(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public void save(Rent rent) {
        rentRepository.save(rent);
    }

    @Override
    public Rent show(int id) {
        return rentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Rent not found with id: " + id));
    }

    @Override
    public List<Rent> findAllRentsBy(Customer customer) {
        return rentRepository.findAllByCustomer(customer);
    }

    @Override
    public List<Rent> findAllRents() {
        return rentRepository.findAll();
    }
}
