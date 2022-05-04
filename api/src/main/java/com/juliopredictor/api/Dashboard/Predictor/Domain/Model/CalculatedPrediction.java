package com.juliopredictor.api.Dashboard.Predictor.Domain.Model;

import java.util.Map;

public class CalculatedPrediction {

    private final Map<String, UncalculatePrediction> prediction;

    public CalculatedPrediction(Map<String, UncalculatePrediction> prediction) {
        this.prediction = prediction;
    }


}
