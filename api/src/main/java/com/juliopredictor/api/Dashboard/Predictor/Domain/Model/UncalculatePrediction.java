package com.juliopredictor.api.Dashboard.Predictor.Domain.Model;

import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.responseDto.CoinMarketCapQuotesBaseResponse;

public class UncalculatePrediction {

    private CoinMarketCapQuotesBaseResponse coinMarketCapQuotesBaseResponse;
    private String logo;

    public UncalculatePrediction(CoinMarketCapQuotesBaseResponse coinMarketCapQuotesBaseResponse, String logo) {
        this.coinMarketCapQuotesBaseResponse = coinMarketCapQuotesBaseResponse;
        this.logo = logo;
    }

    public CoinMarketCapQuotesBaseResponse getCoinMarketCapQuotesBaseResponse() {
        return coinMarketCapQuotesBaseResponse;
    }

    public void setCoinMarketCapQuotesBaseResponse(CoinMarketCapQuotesBaseResponse coinMarketCapQuotesBaseResponse) {
        this.coinMarketCapQuotesBaseResponse = coinMarketCapQuotesBaseResponse;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
