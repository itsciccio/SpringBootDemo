package com.example.demo.api.dto;

import lombok.Data;

@Data
public class UpdatePersonRequestDTO {

    private String name;
    private int age = -1;

}
