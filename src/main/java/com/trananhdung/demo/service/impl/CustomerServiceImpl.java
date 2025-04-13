package com.trananhdung.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trananhdung.demo.DTO.LoginDTO;
import com.trananhdung.demo.DTO.LoginResponseDTO;
import com.trananhdung.demo.entity.Cart;
import com.trananhdung.demo.entity.Customer;
import com.trananhdung.demo.entity.Order;
import com.trananhdung.demo.repository.CustomerRepository;
import com.trananhdung.demo.service.CustomerService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SuppressWarnings("unused")
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // @Override
    // public Customer addCustomer(Customer customer) {
    //     Cart cart = new Cart();
    //     customer.addCart(cart);
    //     return customerRepository.save(customer);
    // }
    @Override
    public Customer addCustomer(Customer customer) {
        Cart cart = new Cart();
        customer.addCart(cart);

        // Order order = new Order();
        // customer.addOrder(order);

        return customerRepository.save(customer);
    }

    @Override
    public LoginResponseDTO loginCustomer(LoginDTO loginDTO) {
        Customer customer = customerRepository.findByEmail(loginDTO.getEmail()).orElse(null);
        if (customer != null && loginDTO.getPasswordHash().equals(customer.getPasswordHash())) {
            Cart cart = customer.getCarts().iterator().next();
            // Order order = customer.getOrders().iterator().next();
            return new LoginResponseDTO("Login successful", customer.getId(), cart);
        } else {
            return new LoginResponseDTO("Invalid credentials", null, null);
        }
    }

    @Override
    public Customer getCustomerById(UUID customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(UUID customerId, Customer updatedCustomer) {
        try {
            Customer existingCustomer = customerRepository.findById(customerId).orElse(null);
            if (existingCustomer != null) {
                existingCustomer.setFirstName(updatedCustomer.getFirstName());
                existingCustomer.setLastName(updatedCustomer.getLastName());
                existingCustomer.setFullname(updatedCustomer.getFullname());
                existingCustomer.setPhone(updatedCustomer.getPhone());
                existingCustomer.setEmail(updatedCustomer.getEmail());
                existingCustomer.setAddress(updatedCustomer.getAddress());
                existingCustomer.setBio(updatedCustomer.getBio());
                existingCustomer.setDistrict(updatedCustomer.getDistrict());
                existingCustomer.setStreet(updatedCustomer.getStreet());
                existingCustomer.setTown(updatedCustomer.getTown());
                existingCustomer.setWard(updatedCustomer.getWard());
                existingCustomer.setPasswordHash(updatedCustomer.getPasswordHash());
                existingCustomer.setActive(updatedCustomer.isActive());
                existingCustomer.setRegisteredAt(updatedCustomer.getRegisteredAt());
                return customerRepository.save(existingCustomer);
            } else {
                throw new EntityNotFoundException("Customer not found with id: " + customerId);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Ghi log lỗi
            throw e; // Ném lại lỗi để controller có thể bắt và xử lý
        }
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        Optional<Customer> customerOptional = customerRepository.findByEmail(email);
        return customerOptional.orElse(null);
    }

    @Override
    public boolean checkEmailExists(String email) {
        return customerRepository.findByEmail(email).isPresent();
    }
}
