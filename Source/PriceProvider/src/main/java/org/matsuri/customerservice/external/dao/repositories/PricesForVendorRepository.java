package org.matsuri.customerservice.external.dao.repositories;

import org.matsuri.customerservice.external.dao.entities.GetPricesForVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PricesForVendorRepository extends JpaRepository<GetPricesForVendor, String> {

    @Query(value = "SELECT vpl.InstrumentId, vpl.VendorId, InstrumentDescription, Price, PriceDate " +
                   "FROM VendorPrices vpl " +
                   "INNER JOIN Instrument i " +
                   "ON i.InstrumentId = vpl.InstrumentId " +
                   "WHERE vpl.VendorId = :vendorId", nativeQuery = true)
    List<GetPricesForVendor> getPricesForVendor(String vendorId);

}
