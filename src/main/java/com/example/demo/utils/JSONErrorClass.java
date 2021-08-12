package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JSONErrorClass {

    private String errorCode;

    private String errorMessage;

}
