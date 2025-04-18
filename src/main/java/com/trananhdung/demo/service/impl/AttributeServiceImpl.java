package com.trananhdung.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trananhdung.demo.entity.Attribute;
import com.trananhdung.demo.repository.AttributeRepository;
import com.trananhdung.demo.service.AttributeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeRepository attributeRepository;

    @Override
    public Attribute addAttribute(Attribute attribute) {
        // Check if attribute already has an ID assigned, if yes, reset it to null
        if (attribute.getId() != null) {
            attribute.setId(null);
        }
        return attributeRepository.save(attribute);
    }

    @Override
    public Attribute getAttributeById(UUID attributeId) {
        Optional<Attribute> optionalAttribute = attributeRepository.findById(attributeId);
        return optionalAttribute.orElse(null);
    }

    @Override
    public List<Attribute> getAllAttributes() {
        return attributeRepository.findAll();
    }

    @Override
    public Attribute updateAttribute(UUID attributeId, Attribute updatedAttribute) {
        Attribute existingAttribute = attributeRepository.findById(attributeId).orElse(null);

        if (existingAttribute != null) {
            existingAttribute.setName(updatedAttribute.getName());
            // existingAttribute.setCreatedBy(updatedAttribute.getCreatedBy());
            // existingAttribute.setUpdatedBy(updatedAttribute.getUpdatedBy());
            // You may need to handle productAttributes and attributeValues here

            return attributeRepository.save(existingAttribute);
        }

        return null;
    }

    @Override
    public void deleteAttribute(UUID attributeId) {
        attributeRepository.deleteById(attributeId);
    }
}
