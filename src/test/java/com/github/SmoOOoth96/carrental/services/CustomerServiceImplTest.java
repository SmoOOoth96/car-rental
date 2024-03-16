package com.github.SmoOOoth96.carrental.services;

import com.github.SmoOOoth96.carrental.models.Customer;
import com.github.SmoOOoth96.carrental.repositories.CustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class CustomerServiceImplTest {
    private final CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
    private final CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository);

    @Test
    @DisplayName("Test showCustomerById")
    public void testShowCustomer(){
        int customerId = 1;
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setRents(List.of());
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
        Customer customerDTO = customerService.show(customerId);
        assertEquals(customerId, customerDTO.getId());
        verify(customerRepository, times(1)).findById(customerId);
    }

    @Test
    @DisplayName("Test findAllCustomers")
    public void testFindAllCustomers(){
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setRents(List.of());
        customers.add(customer);
        when(customerRepository.findAll()).thenReturn(customers);
        Collection<Customer> customersDTO = customerService.findAllCustomers();
        assertEquals(customers.size(), customersDTO.size());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Test saveCustomer")
    public void testSaveCustomer(){
        Customer customer = new Customer();
        customerService.save(customer);
        verify(customerRepository, times(1))
                .save(any(Customer.class));
    }

    @Test
    @DisplayName("Test deleteCustomer")
    public void testDeleteCustomer(){
        int customerId = 1;
        customerService.delete(customerId);
        verify(customerRepository, times(1))
                .deleteById(customerId);
    }
}
