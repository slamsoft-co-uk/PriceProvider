package org.matsuri.customerservice.external.services;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.AStandardObjectTest;
import org.matsuri.customerservice.external.dao.entities.GetPricesForVendor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GetPricesForVendorServiceTest extends AStandardObjectTest {

    @Autowired
    private GetPricesForVendorService getPricesForVendorService;

    @Test
    public void getPricesForVendorSuccessfulTest() {
        String vendorId = "V001";
        List<GetPricesForVendor> vendors = getPricesForVendorService.getPricesForVendor(vendorId);
        assertEquals(1, vendors.size());
    }

    @Test
    public void getPricesForVendorFaillTest() {
        List<GetPricesForVendor> vendors = getPricesForVendorService.getPricesForVendor(null);
        assertEquals(0, vendors.size());
    }

}
