package com.example.carrent.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private Long id;
    private String name;
    private String color;
    private int year;
    private String customerName;
    private LocalDate rentEndDate;
    private Provider provider;

    public boolean sendRentRequest(Car car) {
        return provider.sendRentRequest(car); //we can check the result to through an exception if the rent fails
    }
}
