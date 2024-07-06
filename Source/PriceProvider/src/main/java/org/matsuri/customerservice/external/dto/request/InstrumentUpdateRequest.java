package org.matsuri.customerservice.external.dto.request;

import java.util.Objects;

public class InstrumentUpdateRequest {

    private String instrumentId;
    private String instrumentDescription;

    public String getInstrumentId() {
        return instrumentId;
    }

    public InstrumentUpdateRequest(String instrumentId, String instrumentDescription) {
        this.instrumentId = instrumentId;
        this.instrumentDescription = instrumentDescription;
    }

    public String getInstrumentDescription() {
        return instrumentDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentUpdateRequest that = (InstrumentUpdateRequest) o;
        return Objects.equals(instrumentId, that.instrumentId) && Objects.equals(instrumentDescription, that.instrumentDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instrumentId, instrumentDescription);
    }

    @Override
    public String toString() {
        return "InstrumentUpdateRequest{" +
                "instrumentId='" + instrumentId + '\'' +
                ", instrumentDescription='" + instrumentDescription + '\'' +
                '}';
    }
}
