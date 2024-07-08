package org.matsuri.customerservice.external.dao.repositories;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.AStandardObjectTest;
import org.matsuri.customerservice.external.dao.entities.InstrumentIdVendorId;
import org.matsuri.customerservice.external.dao.entities.VendorPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class VendorPricesRepositoryTest extends AStandardObjectTest {

    @Autowired
    private VendorPricesRepository vendorPricesRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertNotEquals(vendorPricesRepository, null);
    }

    @Test
    void testInsertWorksSuccessfully() {
        VendorPrices expectedVPL = new VendorPrices(new InstrumentIdVendorId("In001", "V001"), 123.57, LocalDateTime.now());
        VendorPrices actualVPL = vendorPricesRepository.updateOrInsert(new VendorPrices(expectedVPL.getInstrumentIdVendorId(), expectedVPL.getPrice(), expectedVPL.getPriceDate()));
        assertEquals(expectedVPL.getInstrumentIdVendorId(), actualVPL.getInstrumentIdVendorId());
        assertEquals(expectedVPL.getPrice(), actualVPL.getPrice());
        assertEquals(expectedVPL.getPriceDate(), actualVPL.getPriceDate());
    }

    @Test
    void testUpdateOrInsertFails() {
        Exception exception = assertThrows(InvalidDataAccessApiUsageException.class, () -> vendorPricesRepository.updateOrInsert(null));

        String expectedMessage = "Entity must not be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testInsertHandlesMissingInstrument() {
        VendorPrices vpl = new VendorPrices(new InstrumentIdVendorId("In999", "V999"), 123.57, LocalDateTime.now());
        vendorPricesRepository.updateOrInsert(vpl);
        Exception exception = assertThrows(DataIntegrityViolationException.class, () -> vendorPricesRepository.flush());

        String expectedMessage = "nested exception is org.hibernate.exception.ConstraintViolationException";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}