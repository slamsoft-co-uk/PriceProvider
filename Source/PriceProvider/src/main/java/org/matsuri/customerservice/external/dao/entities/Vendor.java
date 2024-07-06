package org.matsuri.customerservice.external.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendor implements Comparable<Vendor>  {

    @Id
    @Column(name = "VendorId")
    private String vendorId;
    @Column(name = "VendorDescription")
    private String vendorDescription;

    public Vendor() {}

    public Vendor(String vendorId, String vendorDescription) {
        this.vendorId = vendorId;
        this.vendorDescription = vendorDescription;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorDescription() {
        return vendorDescription;
    }

    public void setVendorDescription(String vendorDescription) {
        this.vendorDescription = vendorDescription;
    }

    @Override
    public int compareTo(Vendor vendor) {
        return this.equals(vendor) ? 1 : 0;
    }
}
