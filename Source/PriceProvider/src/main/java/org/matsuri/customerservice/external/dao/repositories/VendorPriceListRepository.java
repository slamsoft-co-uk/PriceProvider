package org.matsuri.customerservice.external.dao.repositories;

import org.matsuri.customerservice.external.dao.entities.VendorPriceList;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface VendorPriceListRepository extends JpaRepository<VendorPriceList, String> {

    @Transactional
    default VendorPriceList updateOrInsert(VendorPriceList vendorPriceList) {
        return save(vendorPriceList);
    }

}
