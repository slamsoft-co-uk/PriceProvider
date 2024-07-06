package org.matsuri.customerservice.external.webcontrollers;

import org.matsuri.customerservice.external.dao.entities.InstrumentIdVendorId;
import org.matsuri.customerservice.external.dao.entities.VendorPriceList;
import org.matsuri.customerservice.external.dto.request.PublishPricesRequest;
import org.matsuri.customerservice.external.services.PublishPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishPricesController {

    private PublishPriceService publishPriceService;

    @Autowired
    public void setAddInstrumentService(PublishPriceService publishPriceService) {
        this.publishPriceService = publishPriceService;
    }

    @RequestMapping(value="/publishPrices", method= RequestMethod.POST)
    public ResponseEntity<String> publishPrices(@RequestBody PublishPricesRequest publishPricesRequest) {
        try {
            publishPriceService.updateOrInsertUsingVendorPriceListRepository(
                    new VendorPriceList(
                            new InstrumentIdVendorId(publishPricesRequest.getInstrumentId(), publishPricesRequest.getVendorId()),
                            publishPricesRequest.getPrice(),
                            publishPricesRequest.getPriceDate())
            );
            return new ResponseEntity<>(String.format("Insertion of a new price for instrument %s, vendor %s complete", publishPricesRequest.getInstrumentId(), publishPricesRequest.getVendorId()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to publish prices.\n" + e.getMessage(),  HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
