package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import com.trananhdung.demo.entity.ShippingRate;

public interface ShippingRateService {
    ShippingRate addShippingRate(ShippingRate shippingRate);
    
    ShippingRate getShippingRateById(UUID shippingRateId);
    
    List<ShippingRate> getAllShippingRates();
    
    ShippingRate updateShippingRate(UUID shippingRateId, ShippingRate updatedShippingRate);
    
    void deleteShippingRate(UUID shippingRateId);
}
