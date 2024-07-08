package org.matsuri.customerservice.external.webcontrollers;

import org.matsuri.customerservice.external.dao.entities.Vendor;
import org.matsuri.customerservice.external.dto.request.VendorUpdateRequest;
import org.matsuri.customerservice.external.services.AddVendorService;
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
public class AddVendorController {

    final Logger logger = LoggerFactory.getLogger(AddVendorController.class);

    private AddVendorService addVendorService;

    @Autowired
    public void setAddInstrumentService(AddVendorService addVendorService) {
        this.addVendorService = addVendorService;
    }

    @RequestMapping(value="/addVendor", method= RequestMethod.POST)
    public ResponseEntity<String> addVendor(@RequestBody VendorUpdateRequest vendorUpdateRequest) {
        try {
            addVendorService.updateOrInsertUsingVendorRepository(new Vendor(vendorUpdateRequest.getVendorId(), vendorUpdateRequest.getVendorDescription()));
            return new ResponseEntity<>(String.format("Insertion of vendor %s complete", vendorUpdateRequest.getVendorId()), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Failed to insert vendor " + e.getMessage());
            return new ResponseEntity<>("Failed to insert vendor",  HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
