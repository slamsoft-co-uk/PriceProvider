package org.matsuri.customerservice.external.services;

import org.matsuri.customerservice.external.dao.entities.*;
import org.matsuri.customerservice.external.dao.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GetVendorsForInstrumentService {

    private VendorsForInstrumentRepository vendorsForInstrumentRepository;

    @Autowired
    public void setGetVendorsForInstrumentRepository(VendorsForInstrumentRepository vendorsForInstrumentRepository) {
        this.vendorsForInstrumentRepository = vendorsForInstrumentRepository;
    }

    public List<GetVendorsForInstrument> getVendorsForInstrument(String instrumentId) {
        return vendorsForInstrumentRepository.getVendorsForInstrument(instrumentId);
    }

}