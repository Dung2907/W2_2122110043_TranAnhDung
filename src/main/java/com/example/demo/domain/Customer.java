package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("unused")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
@JsonIgnoreProperties("carts")

public class Customer extends DateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "phone_number")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "active")
    private boolean active;

    @Column(name = "street")
    private String street;

    @Column(name = "ward")
    private String ward;

    @Column(name = "town")
    private String town;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "bio")
    private String bio;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;


    @JsonManagedReference
    @OneToMany(mappedBy = "customer", targetEntity = Cart.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Cart> carts = new HashSet<Cart>();

    public void addCart(Cart cart) {
        carts.add(cart);
        cart.setCustomer(this);
    }

    public void removeCart(Cart cart) {
        carts.remove(cart);
        cart.setCustomer(null);
    }
    // public void addOrder(Order order) {
    //     orders.add(order);
    //     order.setCustomer(this);
    // }

    // public void removeOrder(Order order) {
    //     orders.remove(order);
    //     order.setCustomer(null);
    // }

    // @JsonManagedReference
    // @OneToMany(mappedBy = "customer", targetEntity = Order.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // private Set<Order> order;
}
