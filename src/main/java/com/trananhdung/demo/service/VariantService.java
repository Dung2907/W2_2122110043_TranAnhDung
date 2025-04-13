package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import com.trananhdung.demo.entity.Variant;

public interface VariantService {
    Variant addVariant(Variant variant);

    List<Variant> getAllVariants();

    void deleteVariant(UUID variantId);
}
