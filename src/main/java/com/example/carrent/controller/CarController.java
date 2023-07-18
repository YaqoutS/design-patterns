package com.example.carrent.controller;

import com.example.carrent.model.Car;
import com.example.carrent.model.FirstProvider;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private final FirstProvider firstProvider;

    public CarController(FirstProvider firstProvider) {
        this.firstProvider = firstProvider;
    }

    @PutMapping("/cars/rent")
    public void rent(@Valid @RequestBody Car car) {
        car.setProvider(firstProvider); //just for testing
        car.sendRentRequest(car);
    }
}
