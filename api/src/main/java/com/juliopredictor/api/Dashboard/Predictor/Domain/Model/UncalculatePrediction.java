package com.juliopredictor.api.Dashboard.Predictor.Domain.Model;

import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.responseDto.CoinMarketCapQuotesBaseResponse;

public class UncalculatePrediction {
    private boolean isBull;
    private Double price;
    private Long volume_24h;
    private Double volume_change_24h;
    private Double percent_change_1h;
    private Double percent_change_24h;
    private Double percent_change_7d;
    private Double percent_change_30d;
    private Double percent_change_60d;
    private Double percent_change_90d;
    private String logo;

    public UncalculatePrediction(Double price, Long volume_24h, Double volume_change_24h, Double percent_change_1h, Double percent_change_24h, Double percent_change_7d, Double percent_change_30d, Double percent_change_60d, Double percent_change_90d, String logo) {
        this.price = price;
        this.volume_24h = volume_24h;
        this.volume_change_24h = volume_change_24h;
        this.percent_change_1h = percent_change_1h;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_7d = percent_change_7d;
        this.percent_change_30d = percent_change_30d;
        this.percent_change_60d = percent_change_60d;
        this.percent_change_90d = percent_change_90d;
        this.logo = logo;
    }

    public UncalculatePrediction(boolean isBull, Double price, Long volume_24h, Double volume_change_24h, Double percent_change_1h, Double percent_change_24h, Double percent_change_7d, Double percent_change_30d, Double percent_change_60d, Double percent_change_90d, String logo) {
        this.isBull = isBull;
        this.price = price;
        this.volume_24h = volume_24h;
        this.volume_change_24h = volume_change_24h;
        this.percent_change_1h = percent_change_1h;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_7d = percent_change_7d;
        this.percent_change_30d = percent_change_30d;
        this.percent_change_60d = percent_change_60d;
        this.percent_change_90d = percent_change_90d;
        this.logo = logo;
    }

    public boolean isBull() {
        return isBull;
    }

    public void setBull(boolean bull) {
        isBull = bull;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getVolume_24h() {
        return volume_24h;
    }

    public void setVolume_24h(Long volume_24h) {
        this.volume_24h = volume_24h;
    }

    public Double getVolume_change_24h() {
        return volume_change_24h;
    }

    public void setVolume_change_24h(Double volume_change_24h) {
        this.volume_change_24h = volume_change_24h;
    }

    public Double getPercent_change_1h() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(Double percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public Double getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(Double percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public Double getPercent_change_7d() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(Double percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }

    public Double getPercent_change_30d() {
        return percent_change_30d;
    }

    public void setPercent_change_30d(Double percent_change_30d) {
        this.percent_change_30d = percent_change_30d;
    }

    public Double getPercent_change_60d() {
        return percent_change_60d;
    }

    public void setPercent_change_60d(Double percent_change_60d) {
        this.percent_change_60d = percent_change_60d;
    }

    public Double getPercent_change_90d() {
        return percent_change_90d;
    }

    public void setPercent_change_90d(Double percent_change_90d) {
        this.percent_change_90d = percent_change_90d;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
