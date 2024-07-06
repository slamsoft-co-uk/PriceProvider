package org.matsuri.customerservice.external.services;

import org.matsuri.customerservice.external.dao.entities.*;
import org.matsuri.customerservice.external.dao.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PublishPriceService {

    private VendorPriceListRepository vendorPriceListRepository;

    @Autowired
    public void setVendorRepository(VendorPriceListRepository vendorPriceListRepository) {
        this.vendorPriceListRepository = vendorPriceListRepository;
    }

    public VendorPriceList updateOrInsertUsingVendorPriceListRepository(VendorPriceList vendorPriceList) {
        return vendorPriceListRepository.updateOrInsert(vendorPriceList);
    }

}