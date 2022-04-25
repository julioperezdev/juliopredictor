package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CoinMarketCapClientHistoricalByCurrency extends CoinMarketCapClientConnection{

    @Value("${coinmarketcap.url.base}")
    private String urlBase;

    public ResponseEntity<?> getCurrencyWithPrediction(Long cryptoId){
        HttpEntity<HttpHeaders> headers = getHeadersWithCredentials();
        ResponseEntity<CoinMarketCapListTop300Response> response = instanceRestTemplate()
                .getForEntity(null,
                        CoinMarketCapListTop300Response.class,
                        headers);
        //if(validateIfStatusResponseIsOK(response)) throw new RuntimeException("Doesnt complete the request CoinMarketCap to get top 300 of cryptocurrencies");
        return response;
    }

    private void getCryptoDataToPredict(){
    }

    private String getCryptoCurrencyIconById(Long cryptoId){
        return null;
    }
}
