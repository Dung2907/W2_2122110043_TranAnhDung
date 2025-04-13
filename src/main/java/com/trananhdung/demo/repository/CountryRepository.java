package com.trananhdung.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trananhdung.demo.entity.Country;

import java.util.UUID;

@SuppressWarnings("unused")
public interface CountryRepository extends JpaRepository<Country, Long> {
    // Bạn có thể thêm các phương thức truy vấn tùy chỉnh nếu cần
}
