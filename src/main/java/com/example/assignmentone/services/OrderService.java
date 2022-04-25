package com.example.assignmentone.services;

import com.example.assignmentone.dto.OrderDto;
import com.example.assignmentone.exception.ApiRequestException;
import com.example.assignmentone.models.Order;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrder() throws ApiRequestException;

    OrderDto getOrder(Long id) throws ApiRequestException;

    void addOrder(Order order) throws ApiRequestException;

    void updateOrder(Long id, Order order) throws ApiRequestException;

    void deleteOrder(Long id) throws ApiRequestException;
}
