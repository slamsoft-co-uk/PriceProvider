package org.matsuri.customerservice.external.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instrument implements Comparable<Instrument>  {

    @Id
    @Column(name = "InstrumentId")
    private String instrumentId;
    @Column(name = "InstrumentDescription")
    private String instrumentDescription;

    public Instrument() {}

    public Instrument(String instrumentId, String instrumentDescription) {
        this.instrumentId = instrumentId;
        this.instrumentDescription = instrumentDescription;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getInstrumentDescription() {
        return instrumentDescription;
    }

    public void setInstrumentDescription(String instrumentDescription) {
        this.instrumentDescription = instrumentDescription;
    }

    @Override
    public int compareTo(Instrument instrument) {
        return this.equals(instrument) ? 1 : 0;
    }
}
