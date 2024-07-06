package org.matsuri.customerservice.external.dto.request;

import java.time.LocalDateTime;
import java.util.Objects;

public class PublishPricesRequest {

    private String instrumentId;
    private String vendorId;
    private double price;
    private LocalDateTime priceDate;

    public PublishPricesRequest(String instrumentId, String vendorId, double price, LocalDateTime priceDate) {
        this.instrumentId = instrumentId;
        this.vendorId = vendorId;
        this.price = price;
        this.priceDate = priceDate;
    }

    public String getInstrumentId() {
        return instrumentId;
    }
    public LocalDateTime getPriceDate() {
        return priceDate;
    }
    public String getVendorId() {
        return vendorId;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublishPricesRequest that = (PublishPricesRequest) o;
        return Objects.equals(instrumentId, that.instrumentId) && Objects.equals(vendorId, that.vendorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instrumentId, vendorId);
    }

    @Override
    public String toString() {
        return "PublishPricesRequest{" +
                "instrumentId='" + instrumentId + '\'' +
                ", vendorId='" + vendorId + '\'' +
                ", price=" + price +
                ", priceDate=" + priceDate +
                '}';
    }



}
