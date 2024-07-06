package org.matsuri.customerservice.external.dto.request;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PublishPricesRequestTest {

    @Test
    public void testObjectPopulatesCorrectly() {

        String instrumentId = "In001";
        String vendorId = "V001";
        double price = 12345.78;
        LocalDateTime priceDate = LocalDateTime.now();

        PublishPricesRequest publishPricesRequest = new PublishPricesRequest(instrumentId, vendorId, price, priceDate);

        assertEquals(instrumentId, publishPricesRequest.getInstrumentId());
        assertEquals(vendorId, publishPricesRequest.getVendorId());
        assertEquals(price, publishPricesRequest.getPrice());
        assertEquals(priceDate, publishPricesRequest.getPriceDate());

    }

}
