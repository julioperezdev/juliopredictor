package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CoinMarketCapClientHistoricalByCurrency extends CoinMarketCapClientConnection{

    @Value("${coinmarketcap.url.base}")
    private String urlBase;
    @Value("${coinmarketcap.url.historicalprice}")
    private String historicalPriceEndpoint;
    @Value("${coinmarketcap.parameter.currency}")
    private String currencyParameter;
    @Value("${coinmarketcap.parameter.cryptocurrency}")
    private String cryptoCurrencyParameter;

    public ResponseEntity<?> getCurrencyWithPrediction(CoinMarketCapPredictorRequest coinMarketCapPredictorRequest){
        HttpEntity<HttpHeaders> headers = getHeadersWithCredentials();
        //todo: create a new model to map the historical data of cryptocurrency
        ResponseEntity<CoinMarketCapListTop300Response> HistoricalResponse = instanceRestTemplate()
                .getForEntity(getUrlToGetHistoricalPrice(coinMarketCapPredictorRequest),
                        CoinMarketCapListTop300Response.class,
                        headers);
        //todo: create a new model to map icon of cryptocurrency
        ResponseEntity<CoinMarketCapListTop300Response> IconResponse = instanceRestTemplate()
                .getForEntity(getUrlToGetHistoricalPrice(coinMarketCapPredictorRequest),
                        CoinMarketCapListTop300Response.class,
                        headers);
        //todo: validate if the call was ok from coinMarketCap API
        //if(validateIfStatusResponseIsOK(response)) throw new RuntimeException("Doesnt complete the request CoinMarketCap to get top 300 of cryptocurrencies");
        return null;
    }

    private String getUrlToGetHistoricalPrice(CoinMarketCapPredictorRequest coinMarketCapPredictorRequest) {
        log.info("build url to get historical price for cryptocurrencies");
        return urlBase
                .concat(historicalPriceEndpoint)
                .concat(INITIALIZE_URL_PARAMETER)
                .concat(currencyParameter)
                .concat(coinMarketCapPredictorRequest.getCurrency())
                .concat(NEXT_URL_PARAMETER_SYMBOL)
                .concat(cryptoCurrencyParameter)
                .concat(coinMarketCapPredictorRequest.getCryptoId());
    }

    private void getCryptoDataToPredict(){
    }

    private String getCryptoCurrencyIconById(Long cryptoId){
        return null;
    }
}
