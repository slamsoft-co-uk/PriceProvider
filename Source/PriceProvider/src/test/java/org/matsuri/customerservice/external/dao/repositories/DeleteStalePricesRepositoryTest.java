package org.matsuri.customerservice.external.dao.repositories;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.AStandardObjectTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteStalePricesRepositoryTest extends AStandardObjectTest {

    @Autowired
    private DeleteStalePricesRepository deleteStalePricesRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertNotEquals(deleteStalePricesRepository, null);
    }

    @Test
    void testDeletionOf2RecordsWorksSuccessfully() {
        int recordsDeleted = deleteStalePricesRepository.deleteStaleBooks(LocalDateTime.of(2024,6,1,0,0));
        assertEquals(2, recordsDeleted);
    }

    @Test
    void testDeletionOfAllRecordsWorksSuccessfully() {
        int recordsDeleted = deleteStalePricesRepository.deleteStaleBooks(LocalDateTime.of(2025,6,1,0,0));
        assertEquals(6, recordsDeleted);
    }

    @Test
    void testDeletionOfZeroRecordsWorksSuccessfully() {
        int recordsDeleted = deleteStalePricesRepository.deleteStaleBooks(LocalDateTime.of(2020,6,1,0,0));
        assertEquals(0, recordsDeleted);
    }

    @Test
    void testDeletionOfNullDateIsHandledSuccessfully() {
        int recordsDeleted = deleteStalePricesRepository.deleteStaleBooks(null);
        assertEquals(0, recordsDeleted);
    }

}