package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trananhdung.demo.entity.Product;

public interface ProductService {
    Product addProduct(Product product);

    Product getProductById(UUID productId);

    List<Product> getAllProducts();

    Product updateProduct(UUID productId, Product updatedProduct);

    void deleteProduct(UUID productId);
    List<Product> getProductsByTagName(String tagName);

    Page<Product> getProductsByProductNameContaining(String productName, Pageable pageable);
    List<Product> getProductsByCategoryId(UUID categoryId);
    List<Product> getProductsByCategoryAndSubcategories(UUID categoryId);
}
