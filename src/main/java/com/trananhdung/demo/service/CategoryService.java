package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import com.trananhdung.demo.entity.Category;
import com.trananhdung.demo.entity.Product;

@SuppressWarnings("unused")
public interface CategoryService {

    Category addCategory(Category category);

    Category getCategoryById(UUID categoryId);

    List<Category> getAllCategories();

    Category updateCategory(UUID categoryId, Category category);

    void deleteCategory(UUID categoryId);

    List<Category> getCategoriesByParentId(UUID parentId);
    List<Category> getRootCategories();
    long countProductsByCategoryId(UUID categoryId);
    Optional<Category> getCategoryByName(String categoryName);
}
