package com.trananhdung.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trananhdung.demo.entity.Category;
import com.trananhdung.demo.entity.Product;
import com.trananhdung.demo.repository.CategoryRepository;
import com.trananhdung.demo.repository.ProductRepository;
import com.trananhdung.demo.service.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SuppressWarnings("unused")
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public long countProductsByCategoryId(UUID categoryId) {
        return productRepository.countByCategoryId(categoryId);
    }

    @Override
    public Category addCategory(Category category) {
        if (category.getId() != null) {
            category.setId(null);
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(UUID categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        return optionalCategory.orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        // Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return categoryRepository.findAll();
    }
    @Override
    public List<Category> getRootCategories() {
        return categoryRepository.findRootCategories();
    }
    @Override
    public List<Category> getCategoriesByParentId(UUID parentId) {
        return categoryRepository.findByParentId(parentId);
    }
    @Override
    public Category updateCategory(UUID categoryId, Category updatedCategory) {
        Category existingCategory = categoryRepository.findById(categoryId).orElse(null);

        if (existingCategory != null) {
            existingCategory.setCategoryName(updatedCategory.getCategoryName());
            existingCategory.setImage(updatedCategory.getImage());
            existingCategory.setParentId(updatedCategory.getParentId());
            existingCategory.setCategoryDescription(updatedCategory.getCategoryDescription());
            existingCategory.setIcon(updatedCategory.getIcon());
            existingCategory.setActive(updatedCategory.getActive());
            // existingCategory.setCreatedBy(updatedCategory.getCreatedBy());
            // existingCategory.setUpdatedBy(updatedCategory.getUpdatedBy());

            return categoryRepository.save(existingCategory);
        }

        return null;
    }

    @Override
    public void deleteCategory(UUID categoryId) {
        categoryRepository.deleteById(categoryId);
    }
    
    @Override
    public Optional<Category> getCategoryByName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

}
