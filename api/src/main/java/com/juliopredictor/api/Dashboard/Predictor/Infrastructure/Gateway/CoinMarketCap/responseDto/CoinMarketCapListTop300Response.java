package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoinMarketCapListTop300Response {
    private CoinMarketCapStatusResponse status;
    private List<CoinMarketCapMapEntity> data;
}
