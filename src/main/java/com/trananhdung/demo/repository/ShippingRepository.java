package com.trananhdung.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trananhdung.demo.entity.Shipping;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
}
