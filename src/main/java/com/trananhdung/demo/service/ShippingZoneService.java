package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import com.trananhdung.demo.entity.ShippingZone;

@SuppressWarnings("unused")
public interface ShippingZoneService {
    ShippingZone addShippingZone(ShippingZone shippingZone);
    
    ShippingZone getShippingZoneById(Long shippingZoneId);
    
    List<ShippingZone> getAllShippingZones();
    
    ShippingZone updateShippingZone(Long shippingZoneId, ShippingZone updatedShippingZone);
    
    void deleteShippingZone(Long shippingZoneId);
}
    