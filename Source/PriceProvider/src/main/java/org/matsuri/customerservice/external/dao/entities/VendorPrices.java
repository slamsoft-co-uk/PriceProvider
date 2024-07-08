package org.matsuri.customerservice.external.dao.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class VendorPrices {

    @Id
    @EmbeddedId
    private InstrumentIdVendorId instrumentIdVendorId;

    @Column(name = "Price")
    private double price;
    @Column(name = "PriceDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime priceDate;

    public VendorPrices() {}

    public VendorPrices(InstrumentIdVendorId instrumentIdVendorId, double price, LocalDateTime priceDate) {
        this.instrumentIdVendorId = instrumentIdVendorId;
        this.price = price;
        this.priceDate = priceDate;
    }

    public InstrumentIdVendorId getInstrumentIdVendorId() {
        return instrumentIdVendorId;
    }

    public void setInstrumentIdVendorId(InstrumentIdVendorId instrumentIdVendorId) {
        this.instrumentIdVendorId = instrumentIdVendorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendorPrices that = (VendorPrices) o;
        return instrumentIdVendorId.equals(that.instrumentIdVendorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instrumentIdVendorId);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(LocalDateTime priceDate) {
        this.priceDate = priceDate;
    }

}
