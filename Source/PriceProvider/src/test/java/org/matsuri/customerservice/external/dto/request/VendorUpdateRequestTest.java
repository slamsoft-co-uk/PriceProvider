package org.matsuri.customerservice.external.dto.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorUpdateRequestTest {

    @Test
    public void testObjectPopulatesCorrectly() {

        String vendorId = "V001";
        String vendorDescription = "Description for vendor V001";

        VendorUpdateRequest vendorUpdateRequest = new VendorUpdateRequest(vendorId, vendorDescription);

        assertEquals(vendorId, vendorUpdateRequest.getVendorId());
        assertEquals(vendorDescription, vendorUpdateRequest.getVendorDescription());

    }

}
