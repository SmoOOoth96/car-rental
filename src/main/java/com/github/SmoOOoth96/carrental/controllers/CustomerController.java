package com.github.SmoOOoth96.carrental.controllers;

import com.github.SmoOOoth96.carrental.models.Customer;
import com.github.SmoOOoth96.carrental.services.CustomerService;
import com.github.SmoOOoth96.carrental.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final RentService rentService;

    @Autowired
    public CustomerController(CustomerService customerService, RentService rentService) {
        this.customerService = customerService;
        this.rentService = rentService;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("customerList", customerService.findAllCustomers());
        return "customer/main";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("customer", customerService.show(id));
        model.addAttribute("rentList", rentService.findAllRentsBy(customerService.show(id)));
        return "customer/show";
    }

    @GetMapping("/new")
    public String newCustomerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("customer", customerService.show(id));
        return "customer/edit";
    }

    @PatchMapping("{id}")
    public String update(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        return "redirect:/customers";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id){
        customerService.delete(id);
        return "redirect:/customers";
    }
}
