package org.example.stocktracking.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StockPriceResponse {
    @JsonProperty("OutBlock_1")
    private List<StockPriceDto> items;

    public List<StockPriceDto> getItems() {
        return items;
    }
    public void setItems(List<StockPriceDto> items) {
        this.items = items;
    }
}
