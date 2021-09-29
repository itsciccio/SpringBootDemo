package com.ciccio.ordersservice.service;

import com.ciccio.ordersservice.api.dto.CreateOrderRequestDTO;
import com.ciccio.ordersservice.api.dto.OrderDTO;
import com.ciccio.ordersservice.api.dto.PersonDTO;
import com.ciccio.ordersservice.dao.OrderRepository;
import com.ciccio.ordersservice.model.Order;
import com.ciccio.ordersservice.utils.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    final OrderRepository orderRepository;

    final PersonService personService;

    final ModelMapper mapper;

    public void createOrder(CreateOrderRequestDTO createOrderRequestDTO){

        PersonDTO personDTO = personService.getPersonById(createOrderRequestDTO.getPersonId());

        if(personDTO==null){
            throw new EntityNotFoundException("Person not found: "+createOrderRequestDTO.getPersonId());
        }

        Order order = Order.builder()
                .personId(createOrderRequestDTO.getPersonId())
                .totalPrice(createOrderRequestDTO.getTotalPrice())
                .build();
        orderRepository.save(order);
    }

    public List<OrderDTO> getPersonOrders(UUID personId){

        return orderRepository.findByPersonId(personId).stream()
                .map(order -> mapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderById(UUID orderId){
        Order foundOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found: "+orderId));
        return mapper.map(foundOrder, OrderDTO.class);
    }

}
