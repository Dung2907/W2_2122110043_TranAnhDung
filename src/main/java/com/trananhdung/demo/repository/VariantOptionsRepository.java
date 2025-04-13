package com.trananhdung.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trananhdung.demo.entity.VariantOptions;

import java.util.UUID;

public interface VariantOptionsRepository extends JpaRepository<VariantOptions, UUID> {
    // Bạn có thể thêm các phương thức truy vấn tùy chỉnh nếu cần
}
