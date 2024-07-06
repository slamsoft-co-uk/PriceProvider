package org.matsuri.customerservice.external.dao.repositories;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.AStandardObjectTest;
import org.matsuri.customerservice.external.dao.entities.InstrumentIdVendorId;
import org.matsuri.customerservice.external.dao.entities.VendorPriceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class VendorPriceListRepositoryTest extends AStandardObjectTest {

    @Autowired
    private VendorPriceListRepository vendorPriceListRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertNotEquals(vendorPriceListRepository, null);
    }

    @Test
    void testInsertWorksSuccessfully() {
        VendorPriceList expectedVPL = new VendorPriceList(new InstrumentIdVendorId("In001", "V001"), 123.57, LocalDateTime.now());
        VendorPriceList actualVPL = vendorPriceListRepository.updateOrInsert(new VendorPriceList(expectedVPL.getInstrumentIdVendorId(), expectedVPL.getPrice(), expectedVPL.getPriceDate()));
        assertEquals(expectedVPL.getInstrumentIdVendorId(), actualVPL.getInstrumentIdVendorId());
        assertEquals(expectedVPL.getPrice(), actualVPL.getPrice());
        assertEquals(expectedVPL.getPriceDate(), actualVPL.getPriceDate());
    }

    @Test
    void testUpdateOrInsertFails() {
        Exception exception = assertThrows(InvalidDataAccessApiUsageException.class, () -> vendorPriceListRepository.updateOrInsert(null));

        String expectedMessage = "Entity must not be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testInsertHandlesMissingInstrument() {
        VendorPriceList vpl = new VendorPriceList(new InstrumentIdVendorId("In999", "V999"), 123.57, LocalDateTime.now());
        vendorPriceListRepository.updateOrInsert(vpl);
        Exception exception = assertThrows(DataIntegrityViolationException.class, () -> vendorPriceListRepository.flush());

        String expectedMessage = "nested exception is org.hibernate.exception.ConstraintViolationException";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}