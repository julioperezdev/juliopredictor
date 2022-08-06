package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Delivery;

import com.juliopredictor.api.Dashboard.Predictor.Application.predicateByCurrency.Delivery.PredicateByCurrencyEndPoints;
import com.juliopredictor.api.Dashboard.Predictor.Domain.Model.CalculatedPrediction;
import com.juliopredictor.api.Dashboard.Predictor.Domain.Model.UncalculatePrediction;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.requestDto.CoinMarketCapPredictorRequest;
import com.juliopredictor.api.Shared.Infrastructure.Delivery.RestResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/predictor")
@AllArgsConstructor
@Slf4j
public class SpringPredictorController {

    private final PredicateByCurrencyEndPoints predicateByCurrencyEndPoints;

    @PostMapping
    public RestResponse<UncalculatePrediction> predictor(@RequestBody CoinMarketCapPredictorRequest coinMarketCapPredictorRequest){
        UncalculatePrediction predication = predicateByCurrencyEndPoints.getPredication(coinMarketCapPredictorRequest);
        return new RestResponse<>(HttpStatus.GONE, "Prediction was generated",predication);
    }
}
