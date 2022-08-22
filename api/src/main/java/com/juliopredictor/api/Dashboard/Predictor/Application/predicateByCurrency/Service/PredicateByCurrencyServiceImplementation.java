package com.juliopredictor.api.Dashboard.Predictor.Application.predicateByCurrency.Service;

import com.juliopredictor.api.Dashboard.Predictor.Application.predicateByCurrency.Adapter.PredicateByCurrencyAdapter;
import com.juliopredictor.api.Dashboard.Predictor.Domain.Model.UncalculatePrediction;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.requestDto.CoinMarketCapPredictorRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PredicateByCurrencyServiceImplementation implements PredicateByCurrencyService{

    private final Double HIGH_POSITIVE_VOLUME_CHANGE = 15.0;
    private final Double MEDIUM_POSITIVE_VOLUME_CHANGE = 8.5;
    private final Double LOW_POSITIVE_VOLUME_CHANGE = 2.5;
    private final Double LOW_NEGATIVE_VOLUME_CHANGE = -2.5;
    private final Double MEDIUM_NEGATIVE_VOLUME_CHANGE = -8.5;
    private final Double HIGH_NEGATIVE_VOLUME_CHANGE = -15.0;
    private final List<Double> VOLUME_CHANGE_LIST = List.of(15.0,8.5,2.5,-2.5,-8.5,-15.0);

    private final PredicateByCurrencyAdapter predicateByCurrencyAdapter;

    public PredicateByCurrencyServiceImplementation(PredicateByCurrencyAdapter predicateByCurrencyAdapter) {
        this.predicateByCurrencyAdapter = predicateByCurrencyAdapter;
    }

    @Override
    public UncalculatePrediction getCurrencyWithPrediction(CoinMarketCapPredictorRequest coinMarketCapPredictorRequest) {
        UncalculatePrediction currencyWithHistoricalPrices = predicateByCurrencyAdapter.getCurrencyWithHistoricalPrices(coinMarketCapPredictorRequest);
        return calculatePredictionByCurrency(currencyWithHistoricalPrices);
    }

    private UncalculatePrediction calculatePredictionByCurrency(UncalculatePrediction currencyWithHistoricalPrices){
        Boolean calculatedPrediction = null;
        if(hasHighPositiveChange(currencyWithHistoricalPrices)){
            calculatedPrediction = calculateHighPositiveChangeIn24Hrs(currencyWithHistoricalPrices);
        }else if(hasBalanceChange(currencyWithHistoricalPrices)){
            calculatedPrediction = calculateBalanceChangeIn24Hrs(currencyWithHistoricalPrices);
        }else if(hasLowNegativeChange(currencyWithHistoricalPrices)){
            calculatedPrediction = calculateLowNegativeChangeIn24Hrs(currencyWithHistoricalPrices);
        }else if(hasHighNegativeChange(currencyWithHistoricalPrices)){
            calculatedPrediction = calculateHighNegativeChangeIn24Hrs(currencyWithHistoricalPrices);
        }
        Map<Boolean, UncalculatePrediction> predictor = new HashMap<>();
        currencyWithHistoricalPrices.setBull(calculatedPrediction);
        return currencyWithHistoricalPrices;
    }

    private Boolean calculateHighPositiveChangeIn24Hrs(UncalculatePrediction currencyWithHistoricalPrices){
        final Integer oneHour = 45;
        final Integer twentyFourHours = 25;
        final Integer sevenDays = 15;
        final Integer thirtyDays = 10;
        final Integer sixtyDays = 3;
        final Integer ninetyDaysHour = 2;

        return predictCurrencyByPercentage(currencyWithHistoricalPrices, oneHour, twentyFourHours, sevenDays, thirtyDays, sixtyDays, ninetyDaysHour);
    }

    private Boolean calculateBalanceChangeIn24Hrs(UncalculatePrediction currencyWithHistoricalPrices){
        final Integer oneHour = 5;
        final Integer twentyFourHours = 10;
        final Integer sevenDays = 15;
        final Integer thirtyDays = 30;
        final Integer sixtyDays = 25;
        final Integer ninetyDaysHour = 15;

        return predictCurrencyByPercentage(currencyWithHistoricalPrices, oneHour, twentyFourHours, sevenDays, thirtyDays, sixtyDays, ninetyDaysHour);
    }

    private Boolean calculateLowNegativeChangeIn24Hrs(UncalculatePrediction currencyWithHistoricalPrices){
        final Integer oneHour = 15;
        final Integer twentyFourHours = 35;
        final Integer sevenDays = 25;
        final Integer thirtyDays = 10;
        final Integer sixtyDays = 8;
        final Integer ninetyDaysHour = 7;

        return predictCurrencyByPercentage(currencyWithHistoricalPrices, oneHour, twentyFourHours, sevenDays, thirtyDays, sixtyDays, ninetyDaysHour);
    }

    private Boolean calculateHighNegativeChangeIn24Hrs(UncalculatePrediction currencyWithHistoricalPrices){
        final Integer oneHour = 35;
        final Integer twentyFourHours = 35;
        final Integer sevenDays = 15;
        final Integer thirtyDays = 10;
        final Integer sixtyDays = 3;
        final Integer ninetyDaysHour = 2;

        return predictCurrencyByPercentage(currencyWithHistoricalPrices, oneHour, twentyFourHours, sevenDays, thirtyDays, sixtyDays, ninetyDaysHour);
    }

    private Boolean predictCurrencyByPercentage(UncalculatePrediction currencyWithHistoricalPrices,
                                    Integer oneHour,
                                    Integer twentyFourHours,
                                    Integer sevenDays,
                                    Integer thirtyDays,
                                    Integer sixtyDays,
                                    Integer ninetyDays){
        List<Double> allPercentages = new ArrayList<>();
        allPercentages.add(calculatePercentage(currencyWithHistoricalPrices.getPercent_change_1h(), oneHour));
        allPercentages.add(calculatePercentage(currencyWithHistoricalPrices.getPercent_change_24h(), twentyFourHours));
        allPercentages.add(calculatePercentage(currencyWithHistoricalPrices.getPercent_change_7d(), sevenDays));
        allPercentages.add(calculatePercentage(currencyWithHistoricalPrices.getPercent_change_30d(), thirtyDays));
        allPercentages.add(calculatePercentage(currencyWithHistoricalPrices.getPercent_change_60d(), sixtyDays));
        allPercentages.add(calculatePercentage(currencyWithHistoricalPrices.getPercent_change_90d(), ninetyDays));

        Double averageOfHistoricalPrices = averageOfAllPercentages(allPercentages);
        return isBull(averageOfHistoricalPrices);


    }
    private Double calculatePercentage(Double value, Integer percentage){
        return (value * percentage) / 100;
    }

    private Double averageOfAllPercentages(List<Double> allPercentages){
        return allPercentages.stream().mapToDouble(Double::doubleValue).average().orElse(Double.NaN);
    }

    private Boolean isBull(Double averageOfHistoricalPrices){
        return averageOfHistoricalPrices >= 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    private boolean hasHighPositiveChange(UncalculatePrediction currencyWithHistoricalPrices) {
        return currencyWithHistoricalPrices.getVolume_change_24h() >= MEDIUM_POSITIVE_VOLUME_CHANGE;
    }
    private boolean hasBalanceChange(UncalculatePrediction currencyWithHistoricalPrices) {
        return currencyWithHistoricalPrices.getVolume_change_24h() < MEDIUM_POSITIVE_VOLUME_CHANGE && currencyWithHistoricalPrices.getVolume_change_24h() >= LOW_NEGATIVE_VOLUME_CHANGE;
    }
    private boolean hasLowNegativeChange(UncalculatePrediction currencyWithHistoricalPrices) {
        return currencyWithHistoricalPrices.getVolume_change_24h() > MEDIUM_NEGATIVE_VOLUME_CHANGE && currencyWithHistoricalPrices.getVolume_change_24h() < LOW_NEGATIVE_VOLUME_CHANGE;
    }
    private boolean hasHighNegativeChange(UncalculatePrediction currencyWithHistoricalPrices) {
        return currencyWithHistoricalPrices.getVolume_change_24h() <= MEDIUM_NEGATIVE_VOLUME_CHANGE;
    }




}
