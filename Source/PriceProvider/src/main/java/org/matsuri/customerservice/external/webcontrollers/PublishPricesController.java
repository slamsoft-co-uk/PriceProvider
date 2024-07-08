package org.matsuri.customerservice.external.webcontrollers;

import org.matsuri.customerservice.external.dao.entities.InstrumentIdVendorId;
import org.matsuri.customerservice.external.dao.entities.VendorPrices;
import org.matsuri.customerservice.external.dto.request.PublishPricesRequest;
import org.matsuri.customerservice.external.scheduling.ScheduledTasks;
import org.matsuri.customerservice.external.services.PublishPricesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishPricesController {

    final Logger logger = LoggerFactory.getLogger(PublishPricesController.class);

    private PublishPricesService publishPricesService;

    @Autowired
    public void setAddInstrumentService(PublishPricesService publishPricesService) {
        this.publishPricesService = publishPricesService;
    }

    @RequestMapping(value="/publishPrices", method= RequestMethod.POST)
    public ResponseEntity<String> publishPrices(@RequestBody PublishPricesRequest publishPricesRequest) {
        try {
            publishPricesService.updateOrInsertUsingVendorPricesRepository(
                    new VendorPrices(
                            new InstrumentIdVendorId(publishPricesRequest.getInstrumentId(), publishPricesRequest.getVendorId()),
                            publishPricesRequest.getPrice(),
                            publishPricesRequest.getPriceDate())
            );
            return new ResponseEntity<>(String.format("Insertion of a new price for instrument %s, vendor %s complete", publishPricesRequest.getInstrumentId(), publishPricesRequest.getVendorId()), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Failed to publish prices " + e.getMessage());
            return new ResponseEntity<>("Failed to publish prices",  HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
