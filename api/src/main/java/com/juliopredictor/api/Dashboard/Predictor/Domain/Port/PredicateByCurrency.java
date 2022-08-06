package com.juliopredictor.api.Dashboard.Predictor.Domain.Port;

import com.juliopredictor.api.Dashboard.Predictor.Domain.Model.UncalculatePrediction;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.requestDto.CoinMarketCapPredictorRequest;

import java.util.Map;

public interface PredicateByCurrency {
    UncalculatePrediction getCurrencyWithPrediction(CoinMarketCapPredictorRequest coinMarketCapPredictorRequest);
}
