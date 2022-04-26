package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoinMarketCapQuotesAttributeResponse {

    private double price;
    private double volume_24h;
    private double volume_change_24h;
    private double percent_change_1h;
    private double percent_change_24h;
    private double percent_change_7d;
    private double percent_change_30d;
    private double percent_change_60d;
    private double percent_change_90d;
}
