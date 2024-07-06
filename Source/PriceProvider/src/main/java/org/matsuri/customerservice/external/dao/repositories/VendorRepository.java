package org.matsuri.customerservice.external.dao.repositories;

import org.matsuri.customerservice.external.dao.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface VendorRepository extends JpaRepository<Vendor, String> {

    @Transactional
    default Vendor updateOrInsert(Vendor vendor) {
        return save(vendor);
    }

}
