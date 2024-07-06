package org.matsuri.customerservice.external.dao.repositories;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.AStandardObjectTest;
import org.matsuri.customerservice.external.dao.entities.GetVendorsForInstrument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VendorsForInstrumentRepositoryTest extends AStandardObjectTest {

    @Autowired
    private VendorsForInstrumentRepository vendorsForInstrumentRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertNotEquals(vendorsForInstrumentRepository, null);
    }

    @Test
    void testGetVendorsForInstrumentWorksSuccessfully() {
        List<GetVendorsForInstrument> actualInstruments = vendorsForInstrumentRepository.getVendorsForInstrument("In001");
        assertEquals(3, actualInstruments.size());
    }

    @Test
    void testGetVendorsForInstrumentReturnsNothing() {
        List<GetVendorsForInstrument> actualInstruments = vendorsForInstrumentRepository.getVendorsForInstrument("XXXX");
        assertEquals(0, actualInstruments.size());
    }

    @Test
    void testGetVendorsForInstrumentHandlesNull() {
        List<GetVendorsForInstrument> actualInstruments = vendorsForInstrumentRepository.getVendorsForInstrument(null);
        assertEquals(0, actualInstruments.size());
    }

}