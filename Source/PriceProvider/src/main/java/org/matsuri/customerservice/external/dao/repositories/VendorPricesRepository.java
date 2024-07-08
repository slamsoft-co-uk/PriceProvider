package org.matsuri.customerservice.external.dao.repositories;

import org.matsuri.customerservice.external.dao.entities.VendorPrices;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface VendorPricesRepository extends JpaRepository<VendorPrices, String> {

    @Transactional
    default VendorPrices updateOrInsert(VendorPrices vendorPrices) {
        return save(vendorPrices);
    }

}
