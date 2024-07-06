package org.matsuri.customerservice.external.dao.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InstrumentIdVendorId implements Serializable {

    @Column(name = "InstrumentId")
    private String instrumentId;
    @Column(name = "VendorId")
    private String vendorId;

    public InstrumentIdVendorId() {}

    public InstrumentIdVendorId(String instrumentId, String vendorId) {
        this.instrumentId = instrumentId;
        this.vendorId = vendorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentIdVendorId that = (InstrumentIdVendorId) o;
        return instrumentId.equals(that.instrumentId) && vendorId.equals(that.vendorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instrumentId, vendorId);
    }
}
