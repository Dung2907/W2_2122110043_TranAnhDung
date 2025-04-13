package com.trananhdung.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    // Marking cartId as not insertable and updatable
    @Column(name = "cart_id", insertable = false, updatable = false)
    private UUID cartId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false) // Specify the foreign key column
    private Cart cart;

    @Column(name = "product_id", insertable = false, updatable = false)
    private UUID productId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false) // Specify the foreign key column
    private Product product;

    @Column(name = "quantity")
    private int quantity;
}
