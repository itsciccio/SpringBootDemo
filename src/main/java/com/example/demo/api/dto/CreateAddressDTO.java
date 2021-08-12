package com.example.demo.api.dto;

import lombok.Data;

@Data
public class CreateAddressDTO {

    private int houseNumber;
    private String street;
    private String city;

}
