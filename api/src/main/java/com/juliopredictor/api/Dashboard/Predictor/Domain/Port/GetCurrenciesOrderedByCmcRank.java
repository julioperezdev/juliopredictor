package com.juliopredictor.api.Dashboard.Predictor.Domain.Port;

import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.responseDto.CoinMarketCapListTop300Response;

public interface GetCurrenciesOrderedByCmcRank {
    CoinMarketCapListTop300Response getCurrenciesOrderedByCmcRank();
}
