package com.trananhdung.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trananhdung.demo.entity.Cart;
import com.trananhdung.demo.entity.CartItem;
import com.trananhdung.demo.entity.Product;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, UUID> {
    Optional<CartItem> findByProduct_Id(UUID productId);
    void save(Cart cart);
    Optional<CartItem> findByCartAndProduct(Cart cart, Product product);
    // void deleteById(UUID cartItemId);
}
