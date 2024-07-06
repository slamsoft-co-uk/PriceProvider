package org.matsuri.customerservice.external.services;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.AStandardObjectTest;
import org.matsuri.customerservice.external.dao.entities.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddInstrumentServiceTest extends AStandardObjectTest {

    @Autowired
    private AddInstrumentService addInstrumentService;

    @Test
    public void updateOrInsertSuccessfulTest() {
        String instrumentId = "I567";
        String instrumentDescription = "I567 Description";
        Instrument instrument = addInstrumentService.updateOrInsertUsingInstrumentRepository(new Instrument(instrumentId, instrumentDescription));
        assertEquals(instrumentId, instrument.getInstrumentId());
        assertEquals(instrumentDescription, instrument.getInstrumentDescription());
    }

    @Test
    public void updateOrInsertFailTest() {
        Exception exception = assertThrows(InvalidDataAccessApiUsageException.class, () -> addInstrumentService.updateOrInsertUsingInstrumentRepository(null));
        assertTrue(exception.getMessage().contains("Entity must not be null"));
    }

}
