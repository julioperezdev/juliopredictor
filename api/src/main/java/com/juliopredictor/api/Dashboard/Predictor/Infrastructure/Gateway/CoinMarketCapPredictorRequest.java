package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway;

public class CoinMarketCapPredictorRequest {

    private String cryptoId;
    private String currency;

    public String getCryptoId() {
        return cryptoId;
    }

    public void setCryptoId(String cryptoId) {
        this.cryptoId = cryptoId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
