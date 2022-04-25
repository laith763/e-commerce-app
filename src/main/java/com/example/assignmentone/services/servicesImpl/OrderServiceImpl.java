package com.example.assignmentone.services.servicesImpl;


import com.example.assignmentone.dto.OrderDto;
import com.example.assignmentone.exception.ApiRequestException;
import com.example.assignmentone.mappers.OrderMapper;
import com.example.assignmentone.models.Order;
import com.example.assignmentone.repositories.OrderRepositories;
import com.example.assignmentone.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderRepositories orderRepositories;
    @Autowired
    OrderMapper orderMapper;
    @Override
    public List<OrderDto> getAllOrder() throws ApiRequestException {
        List <Order> orderList = orderRepositories.findAll();
        if(orderList.size() == 0) throw new ApiRequestException("No Order in the system");
        return orderMapper.convertListOrderToDto(orderList);
    }

    @Override
    public OrderDto getOrder(Long id) throws ApiRequestException {
        Order order = orderRepositories.findById(id).orElseThrow(() -> new ApiRequestException(String.format("The Order that has id %s not found",id)));
        return orderMapper.convertOrderToDto(order);
    }

    @Override
    public void addOrder(Order order) throws ApiRequestException {
        boolean isOrderAlreadyExists = orderRepositories.findById( order.getOrderId()).isPresent();
        if(isOrderAlreadyExists) throw new ApiRequestException("There is no two Orders should have the same id");
        orderRepositories.save(order);
    }

    @Override
    public void updateOrder(Long id, Order order) throws ApiRequestException {
        boolean isOrderExists = orderRepositories.findById(id).isPresent();
        if(!isOrderExists) throw new ApiRequestException("The Order you are trying to update does not exist");
        orderRepositories.save(order);
    }

    @Override
    public void deleteOrder(Long id) throws ApiRequestException {
        boolean isOrderExists = orderRepositories.findById(id).isPresent();
        if(!isOrderExists) throw new ApiRequestException("The Order you are trying to delete does not exist");
        orderRepositories.deleteById(id);
    }
}
