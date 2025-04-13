package com.trananhdung.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trananhdung.demo.entity.Category;
import com.trananhdung.demo.entity.Product;
import com.trananhdung.demo.entity.Tag;
import com.trananhdung.demo.repository.CategoryRepository;
import com.trananhdung.demo.repository.ProductRepository;
import com.trananhdung.demo.repository.TagRepository;
import com.trananhdung.demo.service.GalleryService;
import com.trananhdung.demo.service.ProductService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private GalleryService galleryService;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getProductsByTagName(String tagName) {
        Tag tag = tagRepository.findByName(tagName);
        if (tag != null) {
            List<Product> products = tag.getProducts();
            // Sắp xếp danh sách sản phẩm theo id lớn hơn
            Collections.sort(products, Comparator.comparing(Product::getId).reversed());
            return products;
        }
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(UUID productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public Product updateProduct(UUID productId, Product updatedProduct) {
        Product existingProduct = productRepository.findById(productId).orElse(null);

        if (existingProduct != null) {
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setSKU(updatedProduct.getSKU());
            existingProduct.setRegularPrice(updatedProduct.getRegularPrice());
            existingProduct.setDiscountPrice(updatedProduct.getDiscountPrice());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            existingProduct.setShortDescription(updatedProduct.getShortDescription());
            existingProduct.setProductDescription(updatedProduct.getProductDescription());
            existingProduct.setCategories(updatedProduct.getCategories());
            existingProduct.setTags(updatedProduct.getTags());
            existingProduct.setProductWeight(updatedProduct.getProductWeight());
            existingProduct.setProductNote(updatedProduct.getProductNote());
            existingProduct.setPublished(updatedProduct.getPublished());
            // existingProduct.setCreatedBy(updatedProduct.getCreatedBy());
            // existingProduct.setUpdatedBy(updatedProduct.getUpdatedBy());
            // You may need to handle other relationships here
            return productRepository.save(existingProduct);
        }

        return null;
    }

    @Override
    public void deleteProduct(UUID productId) {
        galleryService.deleteGalleryByProductId(productId); // Gọi phương thức để xóa các gallery dựa trên productId
        productRepository.deleteById(productId);
    }

    @Override
    public Page<Product> getProductsByProductNameContaining(String productName, Pageable pageable) {
        return productRepository.findByProductNameContains(productName, pageable);
    }

    @Override
    public List<Product> getProductsByCategoryId(UUID categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
    @Override
    public List<Product> getProductsByCategoryAndSubcategories(UUID categoryId) {
        List<UUID> categoryIds = new ArrayList<>();
        gatherCategoryAndSubcategoryIds(categoryId, categoryIds);
        
        List<Product> allProducts = new ArrayList<>();
        for (UUID id : categoryIds) {
            List<Product> products = productRepository.findByCategoryId(id);
            allProducts.addAll(products);
        }
        
        return allProducts;
    }

    private void gatherCategoryAndSubcategoryIds(UUID categoryId, List<UUID> categoryIds) {
        categoryIds.add(categoryId);
        List<Category> subcategories = categoryRepository.findByParentId(categoryId);
        for (Category subcategory : subcategories) {
            gatherCategoryAndSubcategoryIds(subcategory.getId(), categoryIds);
        }
    }
    
}
