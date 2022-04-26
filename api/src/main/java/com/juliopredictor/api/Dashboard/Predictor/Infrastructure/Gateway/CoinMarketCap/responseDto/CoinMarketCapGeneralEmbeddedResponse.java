package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.responseDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoinMarketCapGeneralEmbeddedResponse<T> {

    private Map<String, T> data;
    public Map<String, T> getData() {
        return data;
    }
    public void setData(Map<String, T> data) {
        this.data = data;
    }
}
