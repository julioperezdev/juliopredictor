package com.juliopredictor.api.Dashboard.Predictor.Application.getAllOrderedByCmcRank.Adapter;

import com.juliopredictor.api.Dashboard.Predictor.Domain.Port.GetCurrenciesOrderedByCmcRank;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCapClient;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCapListTop300Response;

public class GetCurrenciesOrderedByCmcRankAdapter implements GetCurrenciesOrderedByCmcRank {

    private final CoinMarketCapClient coinMarketCapClient;

    public GetCurrenciesOrderedByCmcRankAdapter(CoinMarketCapClient coinMarketCapClient) {
        this.coinMarketCapClient = coinMarketCapClient;
    }

    public CoinMarketCapListTop300Response getCurrenciesOrderedByCmcRank() throws Exception {
        return coinMarketCapClient.listTop300ByCmcRank();
    }

}
