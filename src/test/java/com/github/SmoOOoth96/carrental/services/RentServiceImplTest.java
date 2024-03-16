package com.github.SmoOOoth96.carrental.services;

import com.github.SmoOOoth96.carrental.models.Car;
import com.github.SmoOOoth96.carrental.models.Customer;
import com.github.SmoOOoth96.carrental.models.Rent;
import com.github.SmoOOoth96.carrental.repositories.RentRepository;
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

public class RentServiceImplTest {
    private final RentRepository rentRepository = Mockito.mock(RentRepository.class);
    private final RentServiceImpl rentService = new RentServiceImpl(rentRepository);

    @Test
    @DisplayName("Test showRentById")
    public void testShowRent(){
        int rentId = 1;
        Rent rent = new Rent();
        Car car = new Car();
        Customer customer = new Customer();
        rent.setId(rentId);
        rent.setCar(car);
        rent.setCustomer(customer);
        when(rentRepository.findById(rentId)).thenReturn(Optional.of(rent));
        Rent rentDTO = rentService.show(rentId);
        assertEquals(rentId, rentDTO.getId());
        verify(rentRepository, times(1)).findById(rentId);
    }

    @Test
    @DisplayName("Test findAllRents")
    public void testFindAllRents(){
        List<Rent> rents = new ArrayList<>();
        Rent rent = new Rent();
        Car car = new Car();
        Customer customer = new Customer();
        rent.setId(1);
        rent.setCar(car);
        rent.setCustomer(customer);
        rents.add(rent);
        when(rentRepository.findAll()).thenReturn(rents);
        Collection<Rent> rentsDTO = rentService.findAllRents();
        assertEquals(rents.size(), rentsDTO.size());
        verify(rentRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Test findAllRentsByCustomer")
    public void testFindRentsByCustomer(){
        List<Rent> rents = new ArrayList<>();
        int rentId = 1;
        Rent rent = new Rent();
        Car car = new Car();
        Customer customer = new Customer();
        rent.setId(rentId);
        rent.setCar(car);
        rent.setCustomer(customer);
        rents.add(rent);
        when(rentRepository.findAllByCustomer(customer)).thenReturn(rents);
        Collection<Rent> rentsDTO = rentService.findAllRentsBy(customer);
        assertEquals(rents.size(), rentsDTO.size());
        verify(rentRepository, times(1)).findAllByCustomer(customer);
    }

    @Test
    @DisplayName("Test saveRent")
    public void testSaveRent(){
        Rent rent = new Rent();
        rentService.save(rent);
        verify(rentRepository, times(1))
                .save(any(Rent.class));
    }
}
