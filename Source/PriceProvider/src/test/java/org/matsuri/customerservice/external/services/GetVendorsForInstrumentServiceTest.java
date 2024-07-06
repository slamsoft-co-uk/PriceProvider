package org.matsuri.customerservice.external.services;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.AStandardObjectTest;
import org.matsuri.customerservice.external.dao.entities.GetVendorsForInstrument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetVendorsForInstrumentServiceTest extends AStandardObjectTest {

    @Autowired
    private GetVendorsForInstrumentService getVendorsForInstrumentService;

    @Test
    public void getVendorsForInstrumentsSuccessfulTest() {
        String instrumentId = "In001";
        List<GetVendorsForInstrument> vendors = getVendorsForInstrumentService.getVendorsForInstrument(instrumentId);
        assertEquals(3, vendors.size());
    }

    @Test
    public void getVendorsForInstrumentsFaillTest() {
        List<GetVendorsForInstrument> vendors = getVendorsForInstrumentService.getVendorsForInstrument(null);
        assertEquals(0, vendors.size());
    }

}
