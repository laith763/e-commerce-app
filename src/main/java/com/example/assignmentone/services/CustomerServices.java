package com.example.assignmentone.services;

import com.example.assignmentone.dto.CustomerDto;
import com.example.assignmentone.exception.ApiRequestException;
import com.example.assignmentone.models.Customer;

import java.util.List;

public interface CustomerServices {
    List<CustomerDto> getAllCustomer() throws ApiRequestException;

    CustomerDto getCustomer(Long id) throws ApiRequestException;

    void addCustomer(Customer customer) throws ApiRequestException;

    void updateCustomer(Long id, Customer customer) throws ApiRequestException;

    void deleteCustomer(Long id) throws ApiRequestException;
}
