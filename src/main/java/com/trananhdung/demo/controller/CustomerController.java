package com.trananhdung.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trananhdung.demo.DTO.CustomerDTO;
import com.trananhdung.demo.DTO.LoginDTO;
import com.trananhdung.demo.DTO.LoginResponseDTO;
import com.trananhdung.demo.entity.Customer;
import com.trananhdung.demo.service.CustomerService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/customers")
@CrossOrigin({ "http://localhost:3000", "http://localhost:3001" })
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.addCustomer(customer);
        return ResponseEntity.ok(createdCustomer);
    }

    // @PostMapping("/login")
    // public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDTO)
    // {
    // LoginResponseDTO response = customerService.loginCustomer(loginDTO);
    // if (response.getCustomerId() != null) {
    // return ResponseEntity.ok(response);
    // } else {
    // return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    // }
    // }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        LoginResponseDTO response = customerService.loginCustomer(loginDTO);
        if (response.getCustomerId() != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") UUID customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/{customerId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Customer> updateCustomer(@PathVariable UUID customerId,
            @RequestBody Customer updatedCustomer) {
        try {
            Customer customer = customerService.updateCustomer(customerId, updatedCustomer);
            return ResponseEntity.ok(customer);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // @PutMapping(value="/{customerId}",
    // consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
    // produces = {MediaType.APPLICATION_ATOM_XML_VALUE,
    // MediaType.APPLICATION_JSON_VALUE})
    // public ResponseEntity<Customer> updateCustomer(UUID customerId,
    // @RequestBody Customer updatedCustomer) {
    // Customer customer = customerService.updateCustomer(customerId,
    // updatedCustomer);
    // if (customer != null) {
    // return ResponseEntity.ok(customer);
    // } else {
    // return ResponseEntity.notFound().build();
    // }
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") UUID customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkEmailExists(@RequestParam String email) {
        boolean exists = customerService.checkEmailExists(email);
        return ResponseEntity.ok(exists);
    }
}
