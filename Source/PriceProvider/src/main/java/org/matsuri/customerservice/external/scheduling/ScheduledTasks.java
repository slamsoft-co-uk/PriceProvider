package org.matsuri.customerservice.external.scheduling;

import org.matsuri.customerservice.external.services.DeleteStalePricesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduledTasks {

    final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Value("${no.days.before.price.is.stale}")
    private String noDaysBeforePriceIsStaleString;

    public void setNoDaysBeforePriceIsStaleString(String noDaysBeforePriceIsStaleString) {
        this.noDaysBeforePriceIsStaleString = noDaysBeforePriceIsStaleString;
    }

    private DeleteStalePricesService deleteStalePricesService;

    @Autowired
    public void setDeleteStalePricesService(DeleteStalePricesService deleteStalePricesService) {
        this.deleteStalePricesService = deleteStalePricesService;
    }

    @Scheduled(cron = "0 */5 * * * *")
    public int removeStalePrices() {

        try {
            long noDaysBeforePriceIsStale = Long.parseLong(noDaysBeforePriceIsStaleString);
            logger.info(String.format("Removing stale prices older than %d days", noDaysBeforePriceIsStale));
            int recordsDeleted = deleteStalePricesService.deleteStalePrices(LocalDateTime.now().minusDays(noDaysBeforePriceIsStale));
            logger.info(String.format("Removal process complete - stale prices removed: %d", recordsDeleted));
            return recordsDeleted;
        } catch (NumberFormatException e) {
            String error = "Invalid value set for property no.days.before.price.is.stale";
            logger.error(error, e);
            throw new RuntimeException(error);
        }

    }

}