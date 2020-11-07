package com.tadeuqc.buscaCep.model;

import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MapsResult {
    String status;

    @JsonProperty(value="results")
    Address[] addressesReturned;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Address[] AddressesReturned() {
        return addressesReturned;
    }

    @Override
    public String toString() {
        return "Resultado [status=" + status + ", addressesReturned=" + Arrays.toString(addressesReturned) + "]";
    }
}
