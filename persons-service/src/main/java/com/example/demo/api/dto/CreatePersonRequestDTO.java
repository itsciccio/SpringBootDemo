package com.example.demo.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreatePersonRequestDTO {

    private String name;
    private int age;

    private List<CreateAddressDTO> addresses;

}
