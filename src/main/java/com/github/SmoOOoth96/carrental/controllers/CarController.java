package com.github.SmoOOoth96.carrental.controllers;

import com.github.SmoOOoth96.carrental.models.Car;
import com.github.SmoOOoth96.carrental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("carsList", carService.findAllCars());
        return "car/main";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("car", carService.show(id));
        return "car/show";
    }

    @GetMapping("/new")
    public String newCarForm(Model model){
        model.addAttribute("car", new Car());
        return "car/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("car") Car car){
        carService.save(car);
        return "redirect:/cars";
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("car", carService.show(id));
        return "car/edit";
    }

    @PatchMapping("{id}")
    public String update(@ModelAttribute("car") Car car){
        carService.save(car);
        return "redirect:/cars";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id){
        carService.delete(id);
        return "redirect:/cars";
    }
}
