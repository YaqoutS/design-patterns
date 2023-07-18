package com.example.carrent.model;

import com.example.carrent.service.ProviderService;

public class SecondProviderFactory extends ProviderFactory{
    private final ProviderService providerService;

    public SecondProviderFactory(ProviderService providerService) {
        this.providerService = providerService;
    }

    @Override
    public SecondProvider createProvider() {
        return new SecondProvider(providerService);
    }
}
