package com.juliopredictor.api.Dashboard.Predictor.Application.getAllOrderedByCmcRank.Service;

import com.juliopredictor.api.Dashboard.Predictor.Application.getAllOrderedByCmcRank.Adapter.GetCurrenciesOrderedByCmcRankAdapter;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCapListTop300Response;

public class GetCurrenciesOrderedByCmcRankServiceImplementation implements GetCurrenciesOrderedByCmcRankService{

    private final GetCurrenciesOrderedByCmcRankAdapter getCurrenciesOrderedByCmcRankAdapter;

    public GetCurrenciesOrderedByCmcRankServiceImplementation(GetCurrenciesOrderedByCmcRankAdapter getCurrenciesOrderedByCmcRankAdapter) {
        this.getCurrenciesOrderedByCmcRankAdapter = getCurrenciesOrderedByCmcRankAdapter;
    }

    @Override
    public CoinMarketCapListTop300Response getCurrenciesOrderedByCmcRank() throws Exception {
        return getCurrenciesOrderedByCmcRankAdapter.getCurrenciesOrderedByCmcRank();
    }
}
