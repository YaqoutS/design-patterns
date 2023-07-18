package com.example.carrent.model;

import com.example.carrent.model.Car;
import com.example.carrent.model.Provider;
import com.example.carrent.service.ProviderService;

public class SecondProvider extends Provider {
    private final ProviderService providerService;

    public SecondProvider(ProviderService providerService) {
        this.providerService = providerService;
        name = "provider2";
        location = "xxxx";
        number = "0592222222";
        url = "http://localhost:8085/cars";
    }

    @Override
    boolean sendRentRequest(Car car) {
        //send a request to the provider url
        return providerService.rentCar(url, car);
    }
}
