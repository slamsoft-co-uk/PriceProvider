package org.matsuri.customerservice.external.services;

import org.matsuri.customerservice.external.dao.entities.*;
import org.matsuri.customerservice.external.dao.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GetPricesForVendorService {

    private PricesForVendorRepository pricesForVendorRepository;

    @Autowired
    public void setGetPricesForVendorRepository(PricesForVendorRepository pricesForVendorRepository) {
        this.pricesForVendorRepository = pricesForVendorRepository;
    }

    public List<GetPricesForVendor> getPricesForVendor(String vendorId) {
        return pricesForVendorRepository.getPricesForVendor(vendorId);
    }

}