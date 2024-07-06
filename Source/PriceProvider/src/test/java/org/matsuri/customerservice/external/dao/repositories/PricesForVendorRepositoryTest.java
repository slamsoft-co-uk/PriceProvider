package org.matsuri.customerservice.external.dao.repositories;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.AStandardObjectTest;
import org.matsuri.customerservice.external.dao.entities.GetPricesForVendor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PricesForVendorRepositoryTest extends AStandardObjectTest {

    @Autowired
    private PricesForVendorRepository pricesForVendorRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertNotEquals(pricesForVendorRepository, null);
    }

    @Test
    void testGetPricesWorksSuccessfully() {
        List<GetPricesForVendor> getPricesForVendors = pricesForVendorRepository.getPricesForVendor("V002");
        assertEquals(2, getPricesForVendors.size());
    }

    @Test
    void testGetVendorsForInstrumentReturnsNothing() {
        List<GetPricesForVendor> getPricesForVendors = pricesForVendorRepository.getPricesForVendor("XXXX");
        assertEquals(0, getPricesForVendors.size());
    }

    @Test
    void testGetPricesFailsSilentlyWithNullVendor() {
        List<GetPricesForVendor> getPricesForVendors = pricesForVendorRepository.getPricesForVendor(null);
        assertEquals(0, getPricesForVendors.size());
    }

}