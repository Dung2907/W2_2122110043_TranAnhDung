package com.trananhdung.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carts")
@JsonIgnoreProperties("customers")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;   

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;


    // @OneToMany(mappedBy = "cart")
    // private Set<CartItem> cartItems;
    @JsonManagedReference
    @OneToMany(mappedBy = "cart", targetEntity = CartItem.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CartItem> cartItems = new HashSet<CartItem>();

}
