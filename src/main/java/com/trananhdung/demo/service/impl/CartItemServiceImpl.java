package com.trananhdung.demo.service.impl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trananhdung.demo.DTO.CartItemDTO;
import com.trananhdung.demo.entity.Cart;
import com.trananhdung.demo.entity.CartItem;
import com.trananhdung.demo.entity.Product;
import com.trananhdung.demo.repository.CartItemRepository;
import com.trananhdung.demo.repository.CartRepository;
import com.trananhdung.demo.repository.ProductRepository;
import com.trananhdung.demo.service.CartItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SuppressWarnings("unused")
@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartItem addCartItem(CartItemDTO cartItemDTO) {
        Optional<Cart> optionalCart = cartRepository.findById(cartItemDTO.getCartId());
        Optional<Product> optionalProduct = productRepository.findById(cartItemDTO.getProductId());

        if (optionalCart.isPresent() && optionalProduct.isPresent()) {
            Cart cart = optionalCart.get();
            Product product = optionalProduct.get();

            // Check if product is already in cart
            Optional<CartItem> existingCartItem = cartItemRepository.findByCartAndProduct(cart, product);
            if (existingCartItem.isPresent()) {
                CartItem cartItem = existingCartItem.get();
                cartItem.setQuantity(cartItem.getQuantity() + cartItemDTO.getQuantity());
                return cartItemRepository.save(cartItem);
            } else {
                CartItem newCartItem = new CartItem();
                newCartItem.setCart(cart);
                newCartItem.setProduct(product);
                newCartItem.setQuantity(cartItemDTO.getQuantity());
                return cartItemRepository.save(newCartItem);
            }
        }

        return null;
    }

    @Override
    public CartItem getCartItemById(UUID cartItemId) {
        Optional<CartItem> optionalCartItem = cartItemRepository.findById(cartItemId);
        return optionalCartItem.orElse(null);
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem updateCartItem(UUID cartItemId, CartItem updatedCartItem) {
        CartItem existingCartItem = cartItemRepository.findById(cartItemId).orElse(null);

        if (existingCartItem != null) {
            existingCartItem.setCart(updatedCartItem.getCart());
            existingCartItem.setProduct(updatedCartItem.getProduct());
            existingCartItem.setQuantity(updatedCartItem.getQuantity());
            return cartItemRepository.save(existingCartItem);
        }

        return null;
    }

    // @Override
    // public void deleteCartItem(UUID cartItemId) {
    //     System.out.println(cartItemId);
    //     cartItemRepository.deleteById(cartItemId);
    // }
    private static final Logger logger = LoggerFactory.getLogger(CartItemServiceImpl.class);
    @Override
    @Transactional
    public void deleteCartItemById(UUID cartItemId) {
        logger.info("Checking if CartItem with id {} exists", cartItemId);
        if (cartItemRepository.existsById(cartItemId)) {
            logger.info("CartItem with id {} exists. Deleting...", cartItemId);
            cartItemRepository.deleteById(cartItemId);
            logger.info("CartItem with id {} deleted successfully", cartItemId);
        } else {
            logger.error("CartItem with id {} does not exist", cartItemId);
            throw new IllegalArgumentException("CartItem with id " + cartItemId + " does not exist.");
        }
    }

    @Override
    public CartItem increaseCartItemQuantity(UUID cartItemId, int increment) {
        Optional<CartItem> optionalCartItem = cartItemRepository.findById(cartItemId);

        if (optionalCartItem.isPresent()) {
            CartItem cartItem = optionalCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + increment);
            return cartItemRepository.save(cartItem);
        }

        return null;
    }

    @Override
    public CartItem decreaseCartItemQuantity(UUID cartItemId, int decrement) {
        Optional<CartItem> optionalCartItem = cartItemRepository.findById(cartItemId);

        if (optionalCartItem.isPresent()) {
            CartItem cartItem = optionalCartItem.get();
            int newQuantity = cartItem.getQuantity() - decrement;
            if (newQuantity > 0) {
                cartItem.setQuantity(newQuantity);
                return cartItemRepository.save(cartItem);
            } else {
                // If quantity drops to 0 or less, remove the item from the cart
                cartItemRepository.delete(cartItem);
                return null;
            }
        }

        return null;
    }
}
