package com.ciccio.ordersservice.api.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderDTO {

    private UUID id;
    private UUID personId;
    private float totalPrice;
}
