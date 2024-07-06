package org.matsuri.customerservice.external.services;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.AStandardObjectTest;
import org.matsuri.customerservice.external.dao.entities.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import static org.junit.jupiter.api.Assertions.*;

public class AddVendorServiceTest extends AStandardObjectTest {

    @Autowired
    private AddVendorService addVendorService;

    @Test
    public void updateOrInsertSuccessfulTest() {
        String vendorId = "V567";
        String vendorDescription = "V567 Description";
        Vendor vendor = addVendorService.updateOrInsertUsingVendorRepository(new Vendor(vendorId, vendorDescription));
        assertEquals(vendorId, vendor.getVendorId());
        assertEquals(vendorDescription, vendor.getVendorDescription());
    }

    @Test
    public void updateOrInsertFailTest() {
        Exception exception = assertThrows(InvalidDataAccessApiUsageException.class, () -> addVendorService.updateOrInsertUsingVendorRepository(null));
        assertTrue(exception.getMessage().contains("Entity must not be null"));
    }

}
