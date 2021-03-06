package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoinMarketCapQuotesValuesResponse {
    private Map<String,CoinMarketCapQuotesAttributeResponse> quote;

    /*
    private T price;
    private T volume_24h;
    private T volume_change_24h;
    private T percent_change_1h;
    private T percent_change_24h;
    private T percent_change_7d;
    private T percent_change_30d;
    private T percent_change_60d;
    private T percent_change_90d;

     */
}
