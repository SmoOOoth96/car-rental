package com.github.SmoOOoth96.carrental.repositories;

import com.github.SmoOOoth96.carrental.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
