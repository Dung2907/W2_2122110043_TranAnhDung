package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import com.trananhdung.demo.entity.Coupon;

public interface CouponService {
    Coupon addCoupon(Coupon coupon);

    Coupon getCouponById(UUID couponId);

    List<Coupon> getAllCoupons();

    Coupon updateCoupon(UUID couponId, Coupon updatedCoupon);

    void deleteCoupon(UUID couponId);
}
