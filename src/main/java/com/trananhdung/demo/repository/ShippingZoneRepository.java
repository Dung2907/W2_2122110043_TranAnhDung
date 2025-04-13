package com.trananhdung.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trananhdung.demo.entity.ShippingZone;



public interface ShippingZoneRepository extends JpaRepository<ShippingZone, Long> {
    // Bạn có thể thêm các phương thức truy vấn tùy chỉnh nếu cần
}
