package org.matsuri.customerservice.external.dto.request;

import java.util.Objects;

public class VendorUpdateRequest {

    private String vendorId;
    private String vendorDescription;

    public VendorUpdateRequest(String vendorId, String vendorDescription) {
        this.vendorId = vendorId;
        this.vendorDescription = vendorDescription;
    }

    public String getVendorId() {
        return vendorId;
    }
    public String getVendorDescription() {
        return vendorDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendorUpdateRequest that = (VendorUpdateRequest) o;
        return Objects.equals(vendorId, that.vendorId) && Objects.equals(vendorDescription, that.vendorDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendorId, vendorDescription);
    }

    @Override
    public String toString() {
        return "VendorUpdateRequest{" +
                "vendorId='" + vendorId + '\'' +
                ", vendorDescription='" + vendorDescription + '\'' +
                '}';
    }
}
