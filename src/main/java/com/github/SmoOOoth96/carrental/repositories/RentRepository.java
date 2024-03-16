package com.github.SmoOOoth96.carrental.repositories;

import com.github.SmoOOoth96.carrental.models.Customer;
import com.github.SmoOOoth96.carrental.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {
    List<Rent> findAllByCustomer(Customer customer);
}
