package com.trananhdung.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("unused")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "coupon_id")
    private UUID couponId;

    @ManyToOne
    @JoinColumn(name = "coupon_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Coupon coupon;

    // @JsonManagedReference
    // @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // @JoinColumn(name = "customer_id", referencedColumnName = "id")
    // private Customer customer;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> items = new HashSet<>();

    @Column(name = "order_status_id")
    private UUID statusId;

    @ManyToOne
    @JoinColumn(name = "order_status_id", referencedColumnName = "id", insertable = false, updatable = false)
    private OrderStatus status;

    @Column(name = "order_approved_at")
    private LocalDateTime approvedAt;

    @Column(name = "order_delivered_carrier_date")
    private LocalDateTime deliveredCarrierAt;

    @Column(name = "order_delivered_customer_date")
    private LocalDateTime deliveredCustomerAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> OrderItems;
}
