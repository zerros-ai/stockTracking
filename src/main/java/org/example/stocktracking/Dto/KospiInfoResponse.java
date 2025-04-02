package org.example.stocktracking.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class KospiInfoResponse {
    @JsonProperty("OutBlock_1")
    private List<KospiInfoDto> items;

    public List<KospiInfoDto> getItems() {
        return items;
    }
    public void setItems(List<KospiInfoDto> items) {
        this.items = items;
    }
}
