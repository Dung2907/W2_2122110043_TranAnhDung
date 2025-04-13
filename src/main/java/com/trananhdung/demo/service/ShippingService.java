package com.trananhdung.demo.service;

import java.util.List;

import com.trananhdung.demo.entity.Shipping;

public interface ShippingService {
    Shipping addShipping(Shipping shipping);

    Shipping getShippingById(int shippingId);

    List<Shipping> getAllShippings();

    Shipping updateShipping(int shippingId, Shipping updatedShipping);

    void deleteShipping(int shippingId);
}
