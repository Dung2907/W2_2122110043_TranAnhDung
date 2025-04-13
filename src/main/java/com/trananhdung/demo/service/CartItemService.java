package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import com.trananhdung.demo.DTO.CartItemDTO;
import com.trananhdung.demo.entity.CartItem;

public interface CartItemService {
    CartItem addCartItem(CartItemDTO cartItemDTO);

    CartItem getCartItemById(UUID cartItemId);

    List<CartItem> getAllCartItems();

    CartItem updateCartItem(UUID cartItemId, CartItem updatedCartItem);

    // void deleteCartItem(UUID cartItemId);
    void deleteCartItemById(UUID cartItemId);
    CartItem increaseCartItemQuantity(UUID cartItemId, int increment);
    CartItem decreaseCartItemQuantity(UUID cartItemId, int decrement);
    
}
