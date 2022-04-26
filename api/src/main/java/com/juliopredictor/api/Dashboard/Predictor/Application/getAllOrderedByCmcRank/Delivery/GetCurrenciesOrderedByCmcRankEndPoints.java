package com.juliopredictor.api.Dashboard.Predictor.Application.getAllOrderedByCmcRank.Delivery;

import com.juliopredictor.api.Dashboard.Predictor.Application.getAllOrderedByCmcRank.Service.GetCurrenciesOrderedByCmcRankService;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.responseDto.CoinMarketCapListTop300Response;

public class GetCurrenciesOrderedByCmcRankEndPoints {

    private final GetCurrenciesOrderedByCmcRankService getCurrenciesOrderedByCmcRankService;

    public GetCurrenciesOrderedByCmcRankEndPoints(GetCurrenciesOrderedByCmcRankService getCurrenciesOrderedByCmcRankService) {
        this.getCurrenciesOrderedByCmcRankService = getCurrenciesOrderedByCmcRankService;
    }

    public CoinMarketCapListTop300Response getCurrenciesOrderedByCmcRank() throws Exception {
        return getCurrenciesOrderedByCmcRankService.getCurrenciesOrderedByCmcRank();
    }
}
