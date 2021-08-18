package com.ciccio.ordersservice.api.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateOrderRequestDTO {

    private UUID personId;
    private float totalPrice;

}
