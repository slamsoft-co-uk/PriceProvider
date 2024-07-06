package org.matsuri.customerservice.external.dao.repositories;

import org.matsuri.customerservice.external.dao.entities.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface InstrumentRepository extends JpaRepository<Instrument, String> {

    @Transactional
    default Instrument updateOrInsert(Instrument instrument) {
        return save(instrument);
    }

}
