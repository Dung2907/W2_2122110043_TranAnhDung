package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import com.trananhdung.demo.entity.Sale;

public interface SaleService {
    Sale addSale(Sale sale);

    Sale getSaleById(UUID saleId);

    List<Sale> getAllSales();

    Sale updateSale(UUID saleId, Sale updatedSale);

    void deleteSale(UUID saleId);
}
