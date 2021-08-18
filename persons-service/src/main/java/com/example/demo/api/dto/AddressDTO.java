package com.example.demo.api.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AddressDTO {

    private UUID id;
    private int houseNumber;
    private String street;
    private CityDTO city;
}
