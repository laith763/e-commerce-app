package com.example.assignmentone.controllers;


import com.example.assignmentone.constants.PathConstants;
import com.example.assignmentone.dto.CustomerDto;
import com.example.assignmentone.exception.ApiRequestException;
import com.example.assignmentone.models.Customer;
import com.example.assignmentone.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathConstants.Customer.RESOURSE_BASE_V0)
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @GetMapping
    public List<CustomerDto> getAllCustomer() throws ApiRequestException {
        return customerServices.getAllCustomer();
    }

    @GetMapping(PathConstants.ID)
    public CustomerDto getCustomer(@PathVariable Long id) throws ApiRequestException{
        return customerServices.getCustomer(id);
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) throws ApiRequestException{
        customerServices.addCustomer(customer);
    }

    @PatchMapping(PathConstants.ID)
    public void updateCustomer(@PathVariable Long id,@RequestBody Customer customer) throws ApiRequestException{
        customerServices.updateCustomer(id, customer);
    }
    @DeleteMapping(PathConstants.ID)
    public void deleteCustomer(@PathVariable Long id) throws ApiRequestException{
        customerServices.deleteCustomer(id);
    }
}
