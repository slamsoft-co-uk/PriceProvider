package org.matsuri.customerservice.external.services;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.AStandardObjectTest;
import org.matsuri.customerservice.external.dao.entities.InstrumentIdVendorId;
import org.matsuri.customerservice.external.dao.entities.VendorPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PublishPricesServiceTest extends AStandardObjectTest {

    @Autowired
    private PublishPricesService publishPricesService;

    @Test
    public void publishSuccessfulTest() {
        VendorPrices expectedVendorPrices = new VendorPrices(new InstrumentIdVendorId("In001", "V001"), 123.45, LocalDateTime.now());
        VendorPrices actualVendorPrices = publishPricesService.updateOrInsertUsingVendorPricesRepository(expectedVendorPrices);
        assertEquals(expectedVendorPrices, actualVendorPrices);
    }

    @Test
    public void publishFailTest() {
        Exception exception = assertThrows(InvalidDataAccessApiUsageException.class, () -> publishPricesService.updateOrInsertUsingVendorPricesRepository(null));
        assertTrue(exception.getMessage().contains("Entity must not be null"));
    }

}
