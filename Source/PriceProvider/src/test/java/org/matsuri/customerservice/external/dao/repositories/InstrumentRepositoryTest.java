package org.matsuri.customerservice.external.dao.repositories;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.AStandardObjectTest;
import org.matsuri.customerservice.external.dao.entities.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import static org.junit.jupiter.api.Assertions.*;

public class InstrumentRepositoryTest extends AStandardObjectTest {

    @Autowired
    private InstrumentRepository instrumentRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertNotEquals(instrumentRepository, null);
    }

    @Test
    void testInsertWorksSuccessfully() {
        Instrument expectedInstrument = new Instrument("I998", "I998 Description");
        Instrument actualInstrument = instrumentRepository.updateOrInsert(new Instrument(expectedInstrument.getInstrumentId(), expectedInstrument.getInstrumentDescription()));
        assertEquals(expectedInstrument.getInstrumentId(), actualInstrument.getInstrumentId());
        assertEquals(expectedInstrument.getInstrumentDescription(), actualInstrument.getInstrumentDescription());
    }

    @Test
    void testUpdateOrInsertFails() {
        Exception exception = assertThrows(InvalidDataAccessApiUsageException.class, () -> instrumentRepository.updateOrInsert(null));

        String expectedMessage = "Entity must not be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testUpdateWorksSuccessfully() {
        Instrument expectedInstrument = new Instrument("I998", "I998 Description");
        instrumentRepository.updateOrInsert(new Instrument(expectedInstrument.getInstrumentId(), expectedInstrument.getInstrumentDescription()));
        expectedInstrument.setInstrumentDescription("Something Else");
        Instrument actualInstrument = instrumentRepository.updateOrInsert(new Instrument(expectedInstrument.getInstrumentId(), expectedInstrument.getInstrumentDescription()));
        assertEquals(expectedInstrument.getInstrumentId(), actualInstrument.getInstrumentId());
        assertEquals(expectedInstrument.getInstrumentDescription(), actualInstrument.getInstrumentDescription());
    }

}