package com.example.demo.api.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class PersonDTO {

    private UUID id;
    private String name;
    private int age;

    private List<AddressDTO> addresses;

}
