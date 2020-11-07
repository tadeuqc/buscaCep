package com.tadeuqc.buscaCep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Address {
    @JsonProperty(value = "formatted_address")
    String formattedAddress;

    @JsonProperty("place_id")
    String placeId;

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    @Override
    public String toString() {
        return "[Endereço=" + formattedAddress + ", placeId=" + placeId + "]";
    }
}
