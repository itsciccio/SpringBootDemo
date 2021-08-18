package com.ciccio.ordersservice.api;

import com.ciccio.ordersservice.api.dto.CreateOrderRequestDTO;
import com.ciccio.ordersservice.api.dto.OrderDTO;
import com.ciccio.ordersservice.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api
@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public void createOrder(@RequestBody CreateOrderRequestDTO createOrderRequestDTO){
        orderService.createOrder(createOrderRequestDTO);
    }

    //add request mapping to start /persons
    @GetMapping("/persons/{pID}/orders")
    public List<OrderDTO> getPersonOrders(@PathVariable("pID") UUID personId){
        return orderService.getPersonOrders(personId);
    }

    @GetMapping("/orders/{oID}")
    public OrderDTO getOrderById(@PathVariable("oID") UUID orderId){
        return orderService.getOrderById(orderId);
    }

}
