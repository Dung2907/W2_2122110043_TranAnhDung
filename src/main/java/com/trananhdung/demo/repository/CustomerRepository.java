package com.trananhdung.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trananhdung.demo.entity.Customer;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Optional<Customer> findByEmail(String email);
    // Optional<Customer> findOneByEmailAndPassword(String email, String passwordHash);
    // Customer findByEmail(String email);
    Boolean existsByEmail(String email);
}
