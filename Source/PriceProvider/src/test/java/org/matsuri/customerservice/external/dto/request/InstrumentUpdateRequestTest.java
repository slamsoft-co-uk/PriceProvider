package org.matsuri.customerservice.external.dto.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstrumentUpdateRequestTest {

    @Test
    public void testObjectPopulatesCorrectly() {
        String instrumentId = "In001";
        String instrumentDescription = "Description for instrument In001";
        InstrumentUpdateRequest instrumentUpdateRequest = new InstrumentUpdateRequest(instrumentId, instrumentDescription);
        assertEquals(instrumentId, instrumentUpdateRequest.getInstrumentId());
        assertEquals(instrumentDescription, instrumentUpdateRequest.getInstrumentDescription());
    }

}
