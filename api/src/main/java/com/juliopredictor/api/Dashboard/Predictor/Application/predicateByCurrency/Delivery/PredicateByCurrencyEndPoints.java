package com.juliopredictor.api.Dashboard.Predictor.Application.predicateByCurrency.Delivery;

import com.juliopredictor.api.Dashboard.Predictor.Application.predicateByCurrency.Service.PredicateByCurrencyService;
import com.juliopredictor.api.Dashboard.Predictor.Domain.Model.CalculatedPrediction;
import com.juliopredictor.api.Dashboard.Predictor.Domain.Model.UncalculatePrediction;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.requestDto.CoinMarketCapPredictorRequest;

import java.util.Map;

public class PredicateByCurrencyEndPoints {

    private PredicateByCurrencyService predicateByCurrencyService;

    public PredicateByCurrencyEndPoints(PredicateByCurrencyService predicateByCurrencyService) {
        this.predicateByCurrencyService = predicateByCurrencyService;
    }

    public UncalculatePrediction getPredication(CoinMarketCapPredictorRequest coinMarketCapPredictorRequest){
        return predicateByCurrencyService.getCurrencyWithPrediction(coinMarketCapPredictorRequest);
    }
}
