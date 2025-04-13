package com.trananhdung.demo.DTO;

import java.util.Set;
import java.util.UUID;

import com.trananhdung.demo.entity.Cart;
import com.trananhdung.demo.entity.Order;

@SuppressWarnings("unused")
public class LoginResponseDTO {
    private String message;
    private UUID customerId;
    private Cart cart;
    // private Order order;

    public LoginResponseDTO(String message, UUID customerId, Cart cart) {
        this.message = message;
        this.customerId = customerId;
        this.cart = cart;
        // this.order = order;
    }
    // public Order getOrder() {
    //     return order;
    // }

    // public void setOrder(Order order) {
    //     this.order = order;
    // }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }
}
