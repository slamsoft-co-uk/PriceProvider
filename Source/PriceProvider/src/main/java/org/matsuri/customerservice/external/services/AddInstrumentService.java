package org.matsuri.customerservice.external.services;

import org.matsuri.customerservice.external.dao.entities.*;
import org.matsuri.customerservice.external.dao.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddInstrumentService {

    private InstrumentRepository instrumentRepository;

    @Autowired
    public void setInstrumentRepository(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    public Instrument updateOrInsertUsingInstrumentRepository(Instrument instrument) {
        return instrumentRepository.updateOrInsert(instrument);
    }

}