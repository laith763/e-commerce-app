package com.example.assignmentone.mappers;

import com.example.assignmentone.dto.CustomerDto;
import com.example.assignmentone.models.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CustomerDto convertCustomerToDto(Customer customer){
        CustomerDto customerDto;
        customerDto = modelMapper.map(customer, CustomerDto.class);
        return customerDto;
    }
    public List<CustomerDto> convertListCustomerToDto(List<Customer> customers){
        return customers.stream().map(x -> convertCustomerToDto(x)).collect(Collectors.toList());
    }
    public Customer convertDtoToCustomer(CustomerDto customerDto){
        Customer customer;
        customer = modelMapper.map(customerDto, Customer.class);
        return customer;
    }
    public List<Customer> convertListDtoToCustomer(List<CustomerDto> dto)
    {
        return dto.stream().map(x -> convertDtoToCustomer(x)).collect(Collectors.toList());
    }
}
