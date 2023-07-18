package com.example.carrent.service;

import com.example.carrent.model.Car;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProviderService {
    private final RestTemplate restTemplate;

    public ProviderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<Car> getCars(String providerUrl) {
        ResponseEntity<List<Car>> exchange = restTemplate.exchange(providerUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Car>>() {
        });
        return exchange.getBody();
    }
    public boolean rentCar(String providerUrl, Car car) {
        String url = providerUrl + "/rent";
        ResponseEntity<Boolean> exchange = restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(car, null), boolean.class);
        return exchange.getBody();
        // return restTemplate.patchForObject(providerUrl, car, boolean.class);
    }
}
