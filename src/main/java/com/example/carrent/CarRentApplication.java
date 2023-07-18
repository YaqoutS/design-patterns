package com.example.carrent;

import com.example.carrent.model.*;
import com.example.carrent.service.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CarRentApplication {

    private static final Logger LOG = LoggerFactory.getLogger(CarRentApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(CarRentApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    FirstProvider firstProvider(FirstProviderFactory firstProviderFactory) {
        return firstProviderFactory.createProvider();
    }

    @Bean
    SecondProvider secondProvider(SecondProviderFactory secondProviderFactory) {
        return secondProviderFactory.createProvider();
    }

    @Bean
    FirstProviderFactory firstProviderFactory(ProviderService providerService) {
        return new FirstProviderFactory(providerService);
    }

    @Bean
    SecondProviderFactory secondProviderFactory(ProviderService providerService) {
        return new SecondProviderFactory(providerService);
    }

    @Bean
    CommandLineRunner commandLineRunner (ProviderService providerService, FirstProvider firstProvider, SecondProvider secondProvider) {
        return args -> {
            //get cars form the first provider
            List<Car> cars1 = providerService.getCars(firstProvider.getUrl());
            for (Car car:cars1) {
                car.setProvider(firstProvider);
            }
            LOG.info("Cars fetched from the first provider successfully");
            List<Car> allCars = new ArrayList<>(cars1);

            //get cars form the second provider
            List<Car> cars2 = providerService.getCars(secondProvider.getUrl());
            for (Car car:cars2) {
                car.setProvider(secondProvider);
            }
            LOG.info("Cars fetched from the second provider successfully");
            allCars.addAll(cars2);
        };
    }
}
