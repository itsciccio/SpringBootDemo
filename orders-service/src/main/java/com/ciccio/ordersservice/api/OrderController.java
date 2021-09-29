package com.ciccio.ordersservice.api;

import com.ciccio.ordersservice.api.dto.CreateOrderRequestDTO;
import com.ciccio.ordersservice.api.dto.OrderDTO;
import com.ciccio.ordersservice.api.dto.PersonDTO;
import com.ciccio.ordersservice.service.OrderService;
import com.ciccio.ordersservice.service.PersonService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api
@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    private final PersonService personService;

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

    @GetMapping("/persons/{pID}")
    public PersonDTO getPersonById(@PathVariable("pID") UUID personId){
        return personService.getPersonById(personId);
    }

}
