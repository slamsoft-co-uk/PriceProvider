package org.matsuri.customerservice.external.services;

import org.matsuri.customerservice.external.dao.entities.*;
import org.matsuri.customerservice.external.dao.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishPricesService {

    private VendorPricesRepository vendorPricesRepository;

    @Autowired
    public void setVendorPricesRepository(VendorPricesRepository vendorPricesRepository) {
        this.vendorPricesRepository = vendorPricesRepository;
    }

    public VendorPrices updateOrInsertUsingVendorPricesRepository(VendorPrices vendorPrices) {
        return vendorPricesRepository.updateOrInsert(vendorPrices);
    }

}