package org.matsuri.customerservice.external.webcontrollers;

import org.matsuri.customerservice.external.dao.entities.*;
import org.matsuri.customerservice.external.services.GetPricesForVendorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetPricesForVendorController {

    final Logger logger = LoggerFactory.getLogger(GetPricesForVendorController.class);

    private GetPricesForVendorService getPricesForVendorService;

    @Autowired
    public void setAddInstrumentService(GetPricesForVendorService getPricesForVendorService) {
        this.getPricesForVendorService = getPricesForVendorService;
    }

    @RequestMapping(value="/getPricesForVendor", method=RequestMethod.GET)
    public ResponseEntity<List<GetPricesForVendor>> getPricesForVendor(@Param("vendorId") String vendorId) {
        try {
            List<GetPricesForVendor> pricesForVendor = getPricesForVendorService.getPricesForVendor(vendorId);
            return new ResponseEntity<>(pricesForVendor, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Failed to get prices for vendor " + e.getMessage());
            return new ResponseEntity("Failed to get prices for vendor",  HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}