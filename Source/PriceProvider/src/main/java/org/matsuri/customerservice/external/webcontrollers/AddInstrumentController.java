package org.matsuri.customerservice.external.webcontrollers;

import org.matsuri.customerservice.external.dao.entities.Instrument;
import org.matsuri.customerservice.external.dto.request.InstrumentUpdateRequest;
import org.matsuri.customerservice.external.services.AddInstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddInstrumentController {

    private AddInstrumentService addInstrumentService;

    @Autowired
    public void setAddInstrumentService(AddInstrumentService addInstrumentService) {
        this.addInstrumentService = addInstrumentService;
    }

    @RequestMapping(value="/addInstrument", method=RequestMethod.POST)
    public ResponseEntity<String> addInstrument(@RequestBody InstrumentUpdateRequest instrumentUpdateRequest) {
        try {
            addInstrumentService.updateOrInsertUsingInstrumentRepository(new Instrument(instrumentUpdateRequest.getInstrumentId(), instrumentUpdateRequest.getInstrumentDescription()));
            return new ResponseEntity<>(String.format("Insertion of instrument %s complete", instrumentUpdateRequest.getInstrumentId()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to insert instrument.\n" + e.getMessage(),  HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
