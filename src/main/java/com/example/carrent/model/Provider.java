package com.example.carrent.model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public abstract class Provider {
    String name;
    String location;
    String number;
    String url;

    //any other information

    abstract boolean sendRentRequest(Car car);
}
