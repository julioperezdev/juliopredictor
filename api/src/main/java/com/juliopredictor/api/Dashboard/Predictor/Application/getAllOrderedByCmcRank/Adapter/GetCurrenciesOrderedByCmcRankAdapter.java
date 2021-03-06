package com.juliopredictor.api.Dashboard.Predictor.Application.getAllOrderedByCmcRank.Adapter;

import com.juliopredictor.api.Dashboard.Predictor.Domain.Port.GetCurrenciesOrderedByCmcRank;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.CoinMarketCapClientListTop300;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.responseDto.CoinMarketCapListTop300Response;

public class GetCurrenciesOrderedByCmcRankAdapter implements GetCurrenciesOrderedByCmcRank {

    private final CoinMarketCapClientListTop300 coinMarketCapClientListTop300;

    public GetCurrenciesOrderedByCmcRankAdapter(CoinMarketCapClientListTop300 coinMarketCapClientListTop300) {
        this.coinMarketCapClientListTop300 = coinMarketCapClientListTop300;
    }

    public CoinMarketCapListTop300Response getCurrenciesOrderedByCmcRank() {
        return coinMarketCapClientListTop300.listTop300ByCmcRank();
    }

}
