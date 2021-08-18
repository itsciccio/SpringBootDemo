package com.ciccio.ordersservice.api.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdateOrderRequestDTO {

    private UUID personId;
    private float totalPrice;
}
