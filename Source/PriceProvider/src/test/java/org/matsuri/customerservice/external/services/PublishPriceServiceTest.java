package org.matsuri.customerservice.external.services;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.AStandardObjectTest;
import org.matsuri.customerservice.external.dao.entities.InstrumentIdVendorId;
import org.matsuri.customerservice.external.dao.entities.VendorPriceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PublishPriceServiceTest extends AStandardObjectTest {

    @Autowired
    private PublishPriceService publishPriceService;

    @Test
    public void publishSuccessfulTest() {
        VendorPriceList expectedVendorPriceList = new VendorPriceList(new InstrumentIdVendorId("In001", "V001"), 123.45, LocalDateTime.now());
        VendorPriceList actualVendorPriceList = publishPriceService.updateOrInsertUsingVendorPriceListRepository(expectedVendorPriceList);
        assertEquals(expectedVendorPriceList, actualVendorPriceList);
    }

    @Test
    public void publishFailTest() {
        Exception exception = assertThrows(InvalidDataAccessApiUsageException.class, () -> publishPriceService.updateOrInsertUsingVendorPriceListRepository(null));
        assertTrue(exception.getMessage().contains("Entity must not be null"));
    }

}
