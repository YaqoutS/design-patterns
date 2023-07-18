package com.example.carrent.model;

import com.example.carrent.service.ProviderService;
import lombok.Getter;

public class FirstProvider extends Provider {
    private final ProviderService providerService;

    public FirstProvider(ProviderService providerService) {
        this.providerService = providerService;
        name = "provider1";
        location = "xxxx";
        number = "0591111111";
        url = "http://localhost:8085/cars";
    }

    @Override
    boolean sendRentRequest(Car car) {
        //send a request to the provider url
        return providerService.rentCar(url, car);
    }
}
