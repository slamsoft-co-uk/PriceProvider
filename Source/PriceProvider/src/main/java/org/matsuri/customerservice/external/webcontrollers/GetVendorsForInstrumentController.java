package org.matsuri.customerservice.external.webcontrollers;

import org.matsuri.customerservice.external.dao.entities.GetVendorsForInstrument;
import org.matsuri.customerservice.external.services.GetVendorsForInstrumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class GetVendorsForInstrumentController {

    final Logger logger = LoggerFactory.getLogger(GetVendorsForInstrumentController.class);

    private GetVendorsForInstrumentService getVendorsForInstrumentService;

    @Autowired
    public void setAddInstrumentService(GetVendorsForInstrumentService getVendorsForInstrumentService) {
        this.getVendorsForInstrumentService = getVendorsForInstrumentService;
    }

    @RequestMapping(value="/getVendorsForInstrument", method= RequestMethod.GET)
    public ResponseEntity<List<GetVendorsForInstrument>> getVendorsForInstrument(@Param("instrumentId") String instrumentId) {
        try {
            List<GetVendorsForInstrument> vendorsForInstrument = getVendorsForInstrumentService.getVendorsForInstrument(instrumentId);
            return new ResponseEntity<>(vendorsForInstrument, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Failed to get vendors for instrument " + e.getMessage());
            return new ResponseEntity("Failed to get vendors for instrument",  HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
