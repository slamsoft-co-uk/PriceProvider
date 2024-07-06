package org.matsuri.customerservice.external.dao.repositories;

import org.matsuri.customerservice.external.dao.entities.GetVendorsForInstrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VendorsForInstrumentRepository extends JpaRepository<GetVendorsForInstrument, String> {

    @Query(value = "SELECT vpl.InstrumentId, vpl.VendorId, VendorDescription, Price, PriceDate " +
                   "FROM VendorPriceList vpl " +
                   "INNER JOIN Vendor v ON vpl.VendorId = v.VendorId " +
                   "WHERE vpl.InstrumentId = :instrumentId", nativeQuery = true)
    List<GetVendorsForInstrument> getVendorsForInstrument(String instrumentId);

}
