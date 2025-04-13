package com.trananhdung.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trananhdung.demo.DTO.CartItemDTO;
import com.trananhdung.demo.entity.CartItem;
import com.trananhdung.demo.entity.Category;
import com.trananhdung.demo.entity.Product;
import com.trananhdung.demo.repository.CartItemRepository;
import com.trananhdung.demo.repository.CartRepository;
import com.trananhdung.demo.repository.ProductRepository;
import com.trananhdung.demo.service.CartItemService;
import com.trananhdung.demo.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SuppressWarnings("unused")
@RestController
@RequestMapping("api/cart-items")
@CrossOrigin({ "http://localhost:3000", "http://localhost:3001" })
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping
    public ResponseEntity<List<CartItem>> getAllCartItems() {
        List<CartItem> cartItems = cartItemService.getAllCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItemById(@PathVariable("id") UUID cartItemId) {
        CartItem cartItem = cartItemService.getCartItemById(cartItemId);
        if (cartItem != null) {
            return ResponseEntity.ok(cartItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // @PostMapping
    // public ResponseEntity<CartItem> addCartItem(@RequestBody CartItemDTO
    // cartItemDTO) {
    // // Fetch the product from the database
    // Product product = productService.getProductById(cartItemDTO.getProductId());
    // if (product == null) {
    // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    // }

    // // Create a new CartItem entity
    // CartItem cartItem = new CartItem();
    // cartItem.setProduct(product);
    // cartItem.setQuantity(cartItemDTO.getQuantity());

    // // Save the CartItem
    // CartItem addedCartItem = cartItemService.addCartItem(cartItem);

    // return ResponseEntity.status(HttpStatus.CREATED).body(addedCartItem);
    // }
    @PostMapping
    public ResponseEntity<CartItem> addCartItem(@RequestBody CartItemDTO cartItemDTO) {
        CartItem addedCartItem = cartItemService.addCartItem(cartItemDTO);
        if (addedCartItem != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(addedCartItem);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable("id") UUID cartItemId,
            @RequestBody CartItem updatedCartItem) {
        CartItem cartItem = cartItemService.updateCartItem(cartItemId, updatedCartItem);
        if (cartItem != null) {
            return ResponseEntity.ok(cartItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteCartItem(@PathVariable("id") UUID cartItemId) {
    //     cartItemService.deleteCartItem(cartItemId);
    //     return ResponseEntity.ok().build();
    // }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable UUID id) {
        try {
            cartItemService.deleteCartItemById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/increase/{cartItemId}")
    public ResponseEntity<CartItem> increaseQuantity(@PathVariable UUID cartItemId, @RequestParam int increment) {
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
        if (cartItemOptional.isPresent()) {
            CartItem cartItem = cartItemOptional.get();
            int newQuantity = cartItem.getQuantity() + increment;
            if (newQuantity < 1) {
                return ResponseEntity.badRequest().build();
            }
            cartItem.setQuantity(newQuantity);
            CartItem updatedCartItem = cartItemRepository.save(cartItem);
            return ResponseEntity.ok(updatedCartItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/decrease/{cartItemId}")
    public ResponseEntity<CartItem> decreaseQuantity(@PathVariable UUID cartItemId, @RequestParam int decrement) {
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
        if (cartItemOptional.isPresent()) {
            CartItem cartItem = cartItemOptional.get();
            int newQuantity = cartItem.getQuantity() - decrement;
            if (newQuantity < 1) {
                return ResponseEntity.badRequest().build();
            }
            cartItem.setQuantity(newQuantity);
            CartItem updatedCartItem = cartItemRepository.save(cartItem);
            return ResponseEntity.ok(updatedCartItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
