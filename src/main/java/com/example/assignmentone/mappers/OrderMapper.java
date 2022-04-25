package com.example.assignmentone.mappers;

import com.example.assignmentone.dto.OrderDto;
import com.example.assignmentone.models.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class OrderMapper {

    @Autowired
    private ModelMapper modelMapper;

    public OrderDto convertOrderToDto(Order order){
        OrderDto orderDto;
        orderDto = modelMapper.map(order, OrderDto.class);
        return orderDto;
    }
    public List<OrderDto> convertListOrderToDto(List<Order> orders){
        return orders.stream().map(x -> convertOrderToDto(x)).collect(Collectors.toList());
    }
    public Order convertDtoToOrder(OrderDto orderDto){
        Order order;
        order = modelMapper.map(orderDto, Order.class);
        return order;
    }
    public List<Order> convertListDtoToOrder(List<OrderDto> dto)
    {
        return dto.stream().map(x -> convertDtoToOrder(x)).collect(Collectors.toList());
    }
}
