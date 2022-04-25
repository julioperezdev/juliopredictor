package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Delivery;

import com.juliopredictor.api.Dashboard.Predictor.Application.getAllOrderedByCmcRank.Delivery.GetCurrenciesOrderedByCmcRankEndPoints;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCapListTop300Response;
import com.juliopredictor.api.Shared.Infrastructure.Delivery.RestResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currencies")
@AllArgsConstructor
public class SpringCurrenciesController {

    private final GetCurrenciesOrderedByCmcRankEndPoints getCurrenciesOrderedByCmcRankEndPoints;

    @GetMapping
    public RestResponse<CoinMarketCapListTop300Response> getTop300ListByCmcRank() throws Exception {
        CoinMarketCapListTop300Response currenciesOrderedByCmcRank = getCurrenciesOrderedByCmcRankEndPoints.getCurrenciesOrderedByCmcRank();
        return new RestResponse<>(HttpStatus.FOUND, currenciesOrderedByCmcRank);
    }
}
