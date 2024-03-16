package com.github.SmoOOoth96.carrental.controllers;

import com.github.SmoOOoth96.carrental.models.Rent;
import com.github.SmoOOoth96.carrental.services.CarService;
import com.github.SmoOOoth96.carrental.services.CustomerService;
import com.github.SmoOOoth96.carrental.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rents")
public class RentController {
    private final RentService rentService;
    private final CustomerService customerService;
    private final CarService carService;

    @Autowired
    public RentController(RentService rentService, CustomerService customerService, CarService carService) {
        this.rentService = rentService;
        this.customerService = customerService;
        this.carService = carService;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("rentList", rentService.findAllRents());
        return "rent/main";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("rent", rentService.show(id));
        model.addAttribute("customer", rentService.show(id).getCustomer());
        model.addAttribute("car", rentService.show(id).getCar());
        return "rent/show";
    }

    @GetMapping("/new")
    public String newRentForm(Model model){
        model.addAttribute("rent", new Rent());
        model.addAttribute("customerList", customerService.findAllCustomers());
        model.addAttribute("carList", carService.findAllCars());
        return "rent/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("rent") Rent rent){
        rentService.save(rent);
        return "redirect:/rents";
    }
}
