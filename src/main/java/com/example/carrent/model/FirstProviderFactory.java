package com.example.carrent.model;

import com.example.carrent.service.ProviderService;

public class FirstProviderFactory extends ProviderFactory{
    private final ProviderService providerService;

    public FirstProviderFactory(ProviderService providerService) {
        this.providerService = providerService;
    }

    @Override
    public FirstProvider createProvider() { //I don't know if it is better to make the return type "Provider" rather than "FirstProvider"
        return new FirstProvider(providerService);
    }
}
