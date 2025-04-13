package com.trananhdung.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trananhdung.demo.entity.Attribute;

public interface AttributeRepository extends JpaRepository<Attribute, UUID> {
    // You can add custom query methods if needed
}