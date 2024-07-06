package org.matsuri.customerservice.external.dao.repositories;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.AStandardObjectTest;
import org.matsuri.customerservice.external.dao.entities.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import static org.junit.jupiter.api.Assertions.*;

public class VendorRepositoryTest extends AStandardObjectTest {

    @Autowired
    private VendorRepository vendorRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertNotEquals(vendorRepository, null);
    }

    @Test
    void testInsertWorksSuccessfully() {
        Vendor expectedVendor = new Vendor("V998", "V998 Description");
        Vendor actualVendor = vendorRepository.updateOrInsert(new Vendor(expectedVendor.getVendorId(), expectedVendor.getVendorDescription()));
        assertEquals(expectedVendor.getVendorId(), actualVendor.getVendorId());
        assertEquals(expectedVendor.getVendorDescription(), actualVendor.getVendorDescription());
    }

    @Test
    void testUpdateOrInsertFails() {
        Exception exception = assertThrows(InvalidDataAccessApiUsageException.class, () -> vendorRepository.updateOrInsert(null));

        String expectedMessage = "Entity must not be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testUpdateWorksSuccessfully() {
        Vendor expectedVendor = new Vendor("V998", "V998 Description");
        vendorRepository.updateOrInsert(new Vendor(expectedVendor.getVendorId(), expectedVendor.getVendorDescription()));
        expectedVendor.setVendorDescription("Something Else");
        Vendor actualVendor = vendorRepository.updateOrInsert(new Vendor(expectedVendor.getVendorId(), expectedVendor.getVendorDescription()));
        assertEquals(expectedVendor.getVendorId(), actualVendor.getVendorId());
        assertEquals(expectedVendor.getVendorDescription(), actualVendor.getVendorDescription());
    }
}