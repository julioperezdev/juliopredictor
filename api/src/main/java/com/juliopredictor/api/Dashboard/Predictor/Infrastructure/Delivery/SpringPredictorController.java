package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Delivery;

import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.CoinMarketCapClientHistoricalByCurrency;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.requestDto.CoinMarketCapPredictorRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/predictor")
@AllArgsConstructor
@Slf4j
public class SpringPredictorController {

    private final CoinMarketCapClientHistoricalByCurrency coinMarketCapClientHistoricalByCurrency;

    @GetMapping
    public void predictor(@RequestBody CoinMarketCapPredictorRequest coinMarketCapPredictorRequest){
        coinMarketCapClientHistoricalByCurrency.getCurrencyWithPrediction(coinMarketCapPredictorRequest);
        log.info("was OK");

    }
}
