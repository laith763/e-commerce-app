package com.example.assignmentone.controllers;


import com.example.assignmentone.constants.PathConstants;
import com.example.assignmentone.dto.OrderDto;
import com.example.assignmentone.exception.ApiRequestException;
import com.example.assignmentone.models.Order;
import com.example.assignmentone.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathConstants.Order.RESOURSE_BASE_V0)
public class OrderController {

    @Autowired
    OrderService orderService;


    @GetMapping
    public List<OrderDto> getAllOrders() throws ApiRequestException {
        return orderService.getAllOrder();
    }

    @GetMapping(PathConstants.ID)
    public OrderDto getOrder(@PathVariable Long id) throws ApiRequestException{
        return orderService.getOrder(id);
    }

    @PostMapping
    public void addOrder(@RequestBody Order order) throws ApiRequestException{
        orderService.addOrder(order);
    }

    @PutMapping
    public void updateOrder(@PathVariable Long id,@RequestBody Order order ) throws ApiRequestException{
        orderService.updateOrder(id,order);
    }

    @DeleteMapping
    public void deleteOrder(@PathVariable Long id) throws ApiRequestException{
        orderService.deleteOrder(id);
    }



}
