package com.juliopredictor.api.Dashboard.Predictor.Application.getAllOrderedByCmcRank.Service;

import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.responseDto.CoinMarketCapListTop300Response;

public interface GetCurrenciesOrderedByCmcRankService {

    CoinMarketCapListTop300Response getCurrenciesOrderedByCmcRank() throws Exception;
}
