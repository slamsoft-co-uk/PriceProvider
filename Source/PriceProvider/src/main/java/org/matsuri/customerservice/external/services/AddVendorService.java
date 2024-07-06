package org.matsuri.customerservice.external.services;

import org.matsuri.customerservice.external.dao.entities.*;
import org.matsuri.customerservice.external.dao.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddVendorService {

    private VendorRepository vendorRepository;

    @Autowired
    public void setVendorRepository(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public Vendor updateOrInsertUsingVendorRepository(Vendor vendor) {
        return vendorRepository.updateOrInsert(vendor);
    }

}