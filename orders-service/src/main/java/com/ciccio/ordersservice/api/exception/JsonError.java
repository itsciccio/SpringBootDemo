package com.ciccio.ordersservice.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JsonError {

    private String errorCode;

    private String errorMessage;

}
