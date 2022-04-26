package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.responseDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoinMarketCapEmbeddedToGetInformationResponse {

    private Map<String, CoinMarketCapInformationCurrencyResponse> data;

    public Map<String, CoinMarketCapInformationCurrencyResponse> getData() {
        return data;
    }

    public void setData(Map<String, CoinMarketCapInformationCurrencyResponse> data) {
        this.data = data;
    }
}
