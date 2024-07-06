package org.matsuri.customerservice.external.dao.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class GetPricesForVendor implements Comparable<GetPricesForVendor> {

    @Id
    @Column(name = "instrumentIdVendorId")
    @JsonIgnore
    private InstrumentIdVendorId instrumentIdVendorId;

    @JsonProperty("InstrumentDescription")
    @Column(name = "InstrumentDescription")
    private String instrumentDescription;

    @JsonProperty("Price")
    @Column(name="Price")
    private double price;

    @JsonProperty("PriceDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name="PriceDate", columnDefinition = "DATE")
    private LocalDateTime priceDate;

    public GetPricesForVendor() {}

    public GetPricesForVendor(InstrumentIdVendorId instrumentIdVendorId, String instrumentDescription, double price, LocalDateTime priceDate) {
        this.instrumentIdVendorId = instrumentIdVendorId;
        this.instrumentDescription = instrumentDescription;
        this.price = price;
        this.priceDate = priceDate;
    }

    @Override
    public int compareTo(GetPricesForVendor o) {
        return this.equals(o) ? 1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetPricesForVendor that = (GetPricesForVendor) o;
        return Objects.equals(instrumentIdVendorId, that.instrumentIdVendorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instrumentIdVendorId);
    }

    @Override
    public String toString() {
        return "GetPricesForVendor{" +
                "instrumentIdVendorId=" + instrumentIdVendorId +
                ", instrumentDescription='" + instrumentDescription + '\'' +
                ", price=" + price +
                ", priceDate=" + priceDate +
                '}';
    }
}
