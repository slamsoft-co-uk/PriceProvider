package org.matsuri.customerservice.external.services;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.AStandardObjectTest;
import org.matsuri.customerservice.external.dao.entities.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteStalePricesServiceTest extends AStandardObjectTest {

    @Autowired
    private DeleteStalePricesService deleteStalePricesService;

    @Test
    public void deleteStalePricesSuccessfulTest() {
        int recordsDeleted = deleteStalePricesService.deleteStalePrices(LocalDateTime.of(2024,6,1,0,0,0));
        assertEquals(2, recordsDeleted);
    }

    @Test
    public void deleteNoStalePricesSuccessfulTest() {
        int recordsDeleted = deleteStalePricesService.deleteStalePrices(LocalDateTime.of(2023,6,1,0,0,0));
        assertEquals(0, recordsDeleted);
    }

    @Test
    public void deleteAllPricesSuccessfulTest() {
        int recordsDeleted = deleteStalePricesService.deleteStalePrices(LocalDateTime.of(2025,6,1,0,0,0));
        assertEquals(6, recordsDeleted);
    }

}
