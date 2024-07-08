package org.matsuri.customerservice.external.dao.repositories;

import org.matsuri.customerservice.external.dao.entities.VendorPrices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public interface DeleteStalePricesRepository extends JpaRepository<VendorPrices, String> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM VendorPrices vpl WHERE vpl.PriceDate < :priceDate", nativeQuery = true)
    int deleteStaleBooks(@Param("priceDate") LocalDateTime priceDate);

}
