package com.trananhdung.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trananhdung.demo.entity.Variant;
import com.trananhdung.demo.repository.VariantRepository;
import com.trananhdung.demo.service.VariantService;

import java.util.List;
import java.util.UUID;

@Service
public class VariantServiceImpl implements VariantService {

    @Autowired
    private VariantRepository variantRepository;

    @Override
    public Variant addVariant(Variant variant) {
        return variantRepository.save(variant);
    }

    @Override
    public List<Variant> getAllVariants() {
        return variantRepository.findAll();
    }

    @Override
    public void deleteVariant(UUID variantId) {
        variantRepository.deleteById(variantId);
    }
}
