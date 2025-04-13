package com.trananhdung.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.trananhdung.demo.entity.Product;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findAllByOrderByCreatedAtDesc();
    Page<Product> findByProductNameContains(String productName, Pageable pageable);
    @Query("SELECT COUNT(p) FROM Product p JOIN p.categories c WHERE c.id = :categoryId")
    long countByCategoryId(@Param("categoryId") UUID categoryId);
    @Query("SELECT p FROM Product p JOIN p.categories c WHERE c.id = :categoryId")
    List<Product> findByCategoryId(@Param("categoryId") UUID categoryId);
    @Query("SELECT p FROM Product p JOIN p.categories c WHERE c.parentId.id = :parentId")
    List<Product> findByCategoriesParentId(@Param("parentId") UUID parentId);
}
