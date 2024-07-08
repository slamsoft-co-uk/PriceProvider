package org.matsuri.customerservice.external.dao.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class GetVendorsForInstrument {// implements Comparable<GetVendorsForInstrument> {

    @Id
    @EmbeddedId
    @JsonProperty("InstrumentIdVendorId")
    @Column(name = "InstrumentIdVendorId")
    private InstrumentIdVendorId instrumentIdVendorId;

    @JsonProperty("VendorDescription")
    @Column(name = "VendorDescription")
    private String vendorDescription;

    @JsonProperty("Price")
    @Column(name="Price")
    private double price;

    @JsonProperty("PriceDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name="PriceDate", columnDefinition = "DATE")
    private LocalDateTime priceDate;

    public GetVendorsForInstrument() {}

    public GetVendorsForInstrument(InstrumentIdVendorId instrumentIdVendorId, String vendorDescription, double price, LocalDateTime priceDate) {
        this.instrumentIdVendorId = instrumentIdVendorId;
        this.vendorDescription = vendorDescription;
        this.price = price;
        this.priceDate = priceDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetVendorsForInstrument that = (GetVendorsForInstrument) o;
        return instrumentIdVendorId.equals(that.instrumentIdVendorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instrumentIdVendorId);
    }

    @Override
    public String toString() {
        return "GetPricesForVendor{" +
                "instrumentIdVendorId='" + instrumentIdVendorId + '\'' +
                "vendorDescription='" + vendorDescription + '\'' +
                ", price=" + price +
                ", priceDate=" + priceDate +
                '}';
    }
}
