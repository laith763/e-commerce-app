package com.example.assignmentone.services.servicesImpl;

import com.example.assignmentone.dto.CustomerDto;
import com.example.assignmentone.exception.ApiRequestException;
import com.example.assignmentone.mappers.CustomerMapper;
import com.example.assignmentone.models.Customer;
import com.example.assignmentone.repositories.CustomerRepositories;
import com.example.assignmentone.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServicesImpl implements CustomerServices {

    @Autowired
    CustomerRepositories customerRepositories;
    @Autowired
    CustomerMapper customerMapper;


    @Override
    public List<CustomerDto> getAllCustomer() throws ApiRequestException {
        List <Customer> customerList = customerRepositories.findAll();
        if(customerList.size() == 0) throw new ApiRequestException("No Customer in the system");
        return customerMapper.convertListCustomerToDto(customerList);
    }

    @Override
    public CustomerDto getCustomer(Long id) throws ApiRequestException {
        Customer customer = customerRepositories.findById(id).orElseThrow(() -> new ApiRequestException(String.format("The Customer that has id %s not found",id)));
        return customerMapper.convertCustomerToDto(customer);
    }

    @Override
    public void addCustomer(Customer customer) throws ApiRequestException {
        boolean isCustomerAlreadyExists = customerRepositories.findById(customer.getCustomerId()).isPresent();
        if(isCustomerAlreadyExists) throw new ApiRequestException("There is no two Customers should have the same id");
        customerRepositories.save(customer);
    }

    @Override
    public void updateCustomer(Long id, Customer customer) throws ApiRequestException {
        boolean isCustomerExists = customerRepositories.findById(id).isPresent();
        if(!isCustomerExists) throw new ApiRequestException("The Customer you are trying to update does not exist");
        customerRepositories.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) throws ApiRequestException {
        boolean isCustomerExists = customerRepositories.findById(id).isPresent();
        if(!isCustomerExists) throw new ApiRequestException("The Customer you are trying to delete does not exist");
        customerRepositories.deleteById(id);
    }
}
