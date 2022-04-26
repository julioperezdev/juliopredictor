package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoinMarketCapQuotesAttributeResponse {

    private Double price;
    private Double volume_24h;
    private Double volume_change_24h;
    private Double percent_change_1h;
    private Double percent_change_24h;
    private Double percent_change_7d;
    private Double percent_change_30d;
    private Double percent_change_60d;
    private Double percent_change_90d;
}
