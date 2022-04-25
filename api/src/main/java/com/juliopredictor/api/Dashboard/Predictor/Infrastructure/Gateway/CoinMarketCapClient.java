package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@Slf4j
public class CoinMarketCapClient {

    @Value("${coinmarketcap.credential.apikey}")
    private String apiKey;
    @Value("${coinmarketcap.credential.protocol}")
    private String headerProtocol;
    @Value("${coinmarketcap.url.base}")
    private String urlBase;
    @Value("${coinmarketcap.url.list.cryptocurrencies}")
    private String listTop300CurrenciesEndpoint;
    @Value("${coinmarketcap.parameter.cmcrank}")
    private String sortByCmcRankParameter;
    @Value("${coinmarketcap.parameter.limit}")
    private String limitToListParameter;
    private final String INITIALIZE_URL_PARAMETER = "?";
    private final String NEXT_URL_PARAMETER_SYMBOL = "&";

    public CoinMarketCapListTop300Response listTop300ByCmcRank() throws RestClientResponseException {
        ResponseEntity<CoinMarketCapListTop300Response> response;
        String urlToListTop300ByCmcRank = getUrlToListTop300ByCmcRank();
        HttpEntity<HttpHeaders> headers = getHeadersWithCredentials();
        try {
            response = instanceRestTemplate()
                    .exchange(urlToListTop300ByCmcRank,
                            HttpMethod.GET,
                            headers,
                            CoinMarketCapListTop300Response.class);
        }catch (Exception exception){
        log.error("Error in coinMarketCap client",exception);
        throw new RuntimeException("Doesnt complete the process to listTop300ByCmcRank");
        }
        if (validateIfStatusResponseIsOK(response)) throw new RuntimeException("Doesnt complete the request CoinMarketCap to get top 300 of cryptocurrencies");
        return response.getBody();
    }

    private String getUrlToListTop300ByCmcRank() {
        return urlBase
                .concat(listTop300CurrenciesEndpoint)
                .concat(INITIALIZE_URL_PARAMETER)
                .concat(sortByCmcRankParameter)
                .concat(NEXT_URL_PARAMETER_SYMBOL)
                .concat(limitToListParameter);
    }

    public ResponseEntity<?> getCurrencyWithPrediction(Long cryptoId){
        HttpEntity<HttpHeaders> headers = getHeadersWithCredentials();
        ResponseEntity<CoinMarketCapListTop300Response> response = instanceRestTemplate()
                .getForEntity(urlBase
                                .concat(listTop300CurrenciesEndpoint)
                                .concat(INITIALIZE_URL_PARAMETER)
                                .concat(sortByCmcRankParameter)
                                .concat(NEXT_URL_PARAMETER_SYMBOL)
                                .concat(limitToListParameter),
                        CoinMarketCapListTop300Response.class,
                        headers);
        if(validateIfStatusResponseIsOK(response)) throw new RuntimeException("Doesnt complete the request CoinMarketCap to get top 300 of cryptocurrencies");
        return response;
    }

    private RestTemplate instanceRestTemplate(){
        return new RestTemplate();
    }

    private boolean validateIfStatusResponseIsOK(ResponseEntity<CoinMarketCapListTop300Response> response) {
        return Objects.requireNonNull(response.getBody()).getStatus().getError_code() != 0;
    }

    private void getCryptoDataToPredict(){
    }

    private String getCryptoCurrencyIconById(Long cryptoId){
        return null;
    }

    private HttpEntity<HttpHeaders> getHeadersWithCredentials() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set(headerProtocol,apiKey);
        return new HttpEntity<>(httpHeaders);
    }
}
