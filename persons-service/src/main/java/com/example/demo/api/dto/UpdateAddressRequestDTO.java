package com.example.demo.api.dto;

import lombok.Data;

@Data
public class UpdateAddressRequestDTO {

    private int houseNumber = -1;
    private String street;
    private String city;

}
