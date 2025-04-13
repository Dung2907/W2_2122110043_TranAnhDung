package com.trananhdung.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trananhdung.demo.entity.Category;
import com.trananhdung.demo.service.CategoryService;
import com.trananhdung.demo.service.ProductService;

import java.util.List;
import java.util.UUID;
import java.util.Optional;
@SuppressWarnings("unused")
@RestController
@CrossOrigin({"http://localhost:3000", "http://localhost:3001"})


@RequestMapping("/api/categories")
public class CategoryController {                            
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/root")
    public ResponseEntity<List<Category>> getRootCategories() {
        List<Category> rootCategories = categoryService.getRootCategories();
        if (rootCategories != null && !rootCategories.isEmpty()) {
            return new ResponseEntity<>(rootCategories, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }   
    }
    @GetMapping("/parent/{parentId}")
    public ResponseEntity<List<Category>> getCategoriesByParentId(@PathVariable("parentId") UUID parentId) {
        List<Category> categories = categoryService.getCategoriesByParentId(parentId);
        if (categories != null && !categories.isEmpty()) {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") UUID id) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.addCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") UUID id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/product-count")
    public long countProductsByCategoryId(@PathVariable UUID id) {
        return categoryService.countProductsByCategoryId(id);
    }

    @GetMapping("/name/{categoryName}")
    public Optional<Category> getCategoryByName(@PathVariable String categoryName) {
        return categoryService.getCategoryByName(categoryName);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") UUID categoryId, @RequestBody Category updatedCategory) {
        Category category = categoryService.updateCategory(categoryId, updatedCategory);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
