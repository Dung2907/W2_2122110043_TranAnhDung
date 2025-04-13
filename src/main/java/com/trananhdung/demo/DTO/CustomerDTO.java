package com.trananhdung.demo.DTO;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import com.trananhdung.demo.entity.Cart;
import com.trananhdung.demo.entity.CustomerAddress;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

@SuppressWarnings("unused")
public class CustomerDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String passwordHash;
    private boolean active;
    private LocalDateTime registeredAt;
    private Set<CustomerAddress> addresses;
    private Set<Cart> carts;
    // @OneToMany(mappedBy = "customer")
    // private Set<Order> orders;

    public CustomerDTO (UUID id, String firstName, String lastName, String phone, String email, String passwordHash) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }


    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    
}
