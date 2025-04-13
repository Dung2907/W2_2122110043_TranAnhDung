package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import com.trananhdung.demo.DTO.LoginDTO;
import com.trananhdung.demo.DTO.LoginResponseDTO;
import com.trananhdung.demo.entity.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer getCustomerByEmail(String email);
    Customer getCustomerById(UUID customerId);
    List<Customer> getAllCustomers();
    Customer updateCustomer(UUID customerId, Customer updatedCustomer);
    void deleteCustomer(UUID customerId);
    LoginResponseDTO loginCustomer(LoginDTO loginDTO);
    boolean checkEmailExists(String email);
}
