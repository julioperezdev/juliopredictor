package com.juliopredictor.api.Dashboard.Predictor.Application.predicateByCurrency.Adapter;

import com.juliopredictor.api.Dashboard.Predictor.Domain.Model.UncalculatePrediction;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.CoinMarketCapClientHistoricalByCurrency;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.requestDto.CoinMarketCapPredictorRequest;

public class PredicateByCurrencyAdapter {

    private final CoinMarketCapClientHistoricalByCurrency coinMarketCapClientHistoricalByCurrency;

    public PredicateByCurrencyAdapter(CoinMarketCapClientHistoricalByCurrency coinMarketCapClientHistoricalByCurrency) {
        this.coinMarketCapClientHistoricalByCurrency = coinMarketCapClientHistoricalByCurrency;
    }

    public UncalculatePrediction getCurrencyWithHistoricalPrices(CoinMarketCapPredictorRequest coinMarketCapPredictorRequest){
        return  coinMarketCapClientHistoricalByCurrency.getCurrencyWithHistoricalPrices(coinMarketCapPredictorRequest);
    }
}
