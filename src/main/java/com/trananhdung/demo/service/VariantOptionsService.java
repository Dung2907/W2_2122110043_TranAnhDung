package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import com.trananhdung.demo.entity.VariantOptions;

public interface VariantOptionsService {
    VariantOptions addVariantOptions(VariantOptions variantOptions);
    
    VariantOptions getVariantOptionsById(UUID variantOptionsId);
    
    List<VariantOptions> getAllVariantOptions();
    
    VariantOptions updateVariantOptions(UUID variantOptionsId, VariantOptions updatedVariantOptions);
    
    void deleteVariantOptions(UUID variantOptionsId);
}
