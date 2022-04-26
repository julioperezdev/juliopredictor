package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.requestDto;

public class CoinMarketCapPredictorRequest {

    private Long cryptoId;
    private String currency;

    public Long getCryptoId() {
        return cryptoId;
    }

    public void setCryptoId(Long cryptoId) {
        this.cryptoId = cryptoId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
