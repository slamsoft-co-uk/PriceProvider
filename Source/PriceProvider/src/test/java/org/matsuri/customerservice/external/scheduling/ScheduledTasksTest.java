package org.matsuri.customerservice.external.scheduling;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.AStandardObjectTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class ScheduledTasksTest extends AStandardObjectTest {

    @Autowired
    private ScheduledTasks scheduledTasks;

    @Test
    public void testDeletionOfStaleTradesExpectSuccess() {
        scheduledTasks.setNoDaysBeforePriceIsStaleString("30");
        int deletedRecords = scheduledTasks.removeStalePrices();
        assertEquals(2, deletedRecords);
    }

    @Test
    public void testDeletionOfAllTradesExpectSuccess() {
        scheduledTasks.setNoDaysBeforePriceIsStaleString("0");
        assertEquals(6, scheduledTasks.removeStalePrices());
        assertEquals(0, scheduledTasks.removeStalePrices());
    }

    @Test
    public void testDeletionOfStaleTradesExpectFailure() {
        scheduledTasks.setNoDaysBeforePriceIsStaleString("");
        Exception exception = assertThrows(RuntimeException.class, () -> scheduledTasks.removeStalePrices());
        assertTrue(exception.getMessage().contains("Invalid value set for property no.days.before.price.is.stale"));
    }

}
