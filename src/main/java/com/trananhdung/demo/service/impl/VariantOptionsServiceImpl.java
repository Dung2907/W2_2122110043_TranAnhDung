package com.trananhdung.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trananhdung.demo.entity.VariantOptions;
import com.trananhdung.demo.repository.VariantOptionsRepository;
import com.trananhdung.demo.service.VariantOptionsService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VariantOptionsServiceImpl implements VariantOptionsService {

    @Autowired
    private VariantOptionsRepository variantOptionsRepository;

    @Override
    public VariantOptions addVariantOptions(VariantOptions variantOptions) {
        // Đảm bảo rằng id của đối tượng VariantOptions là null trước khi lưu vào cơ sở dữ liệu
        variantOptions.setId(null);
        return variantOptionsRepository.save(variantOptions);
    }

    @Override
    public VariantOptions getVariantOptionsById(UUID variantOptionsId) {
        Optional<VariantOptions> optionalVariantOptions = variantOptionsRepository.findById(variantOptionsId);
        return optionalVariantOptions.orElse(null);
    }

    @Override
    public List<VariantOptions> getAllVariantOptions() {
        return variantOptionsRepository.findAll();
    }

    @Override
    public VariantOptions updateVariantOptions(UUID variantOptionsId, VariantOptions updatedVariantOptions) {
        VariantOptions existingVariantOptions = variantOptionsRepository.findById(variantOptionsId).orElse(null);

        if (existingVariantOptions != null) {
            existingVariantOptions.setTitle(updatedVariantOptions.getTitle());
            existingVariantOptions.setGallery(updatedVariantOptions.getGallery());
            existingVariantOptions.setProduct(updatedVariantOptions.getProduct());
            existingVariantOptions.setSalePrice(updatedVariantOptions.getSalePrice());
            existingVariantOptions.setComparePrice(updatedVariantOptions.getComparePrice());
            existingVariantOptions.setBuyingPrice(updatedVariantOptions.getBuyingPrice());
            existingVariantOptions.setQuantity(updatedVariantOptions.getQuantity());
            existingVariantOptions.setSku(updatedVariantOptions.getSku());
            existingVariantOptions.setActive(updatedVariantOptions.isActive());
            // Cập nhật các trường khác nếu cần

            return variantOptionsRepository.save(existingVariantOptions);
        }

        return null;
    }

    @Override
    public void deleteVariantOptions(UUID variantOptionsId) {
        variantOptionsRepository.deleteById(variantOptionsId);
    }
}
