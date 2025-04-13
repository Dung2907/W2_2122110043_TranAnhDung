package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import com.trananhdung.demo.entity.Supplier;

public interface SupplierService {
    Supplier addSupplier(Supplier supplier);
    
    Supplier getSupplierById(UUID supplierId);
    
    List<Supplier> getAllSuppliers();
    
    Supplier updateSupplier(UUID supplierId, Supplier updatedSupplier);
    
    void deleteSupplier(UUID supplierId);
}
