package org.example.stocktracking.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;



public class StockInfoResponse {
    @JsonProperty("OutBlock_1")
    private List<StockInfoDto> items;

    public List<StockInfoDto> getItems() {
        return items;
    }
    public void setItems(List<StockInfoDto> items) {
        this.items = items;
    }
}
