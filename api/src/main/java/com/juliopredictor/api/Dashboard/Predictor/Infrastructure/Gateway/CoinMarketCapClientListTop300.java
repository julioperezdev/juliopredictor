package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;

import java.util.Objects;

@Service
@Slf4j
public class CoinMarketCapClientListTop300 extends CoinMarketCapClientConnection{

    @Value("${coinmarketcap.url.base}")
    private String urlBase;
    @Value("${coinmarketcap.url.list.cryptocurrencies}")
    private String listTop300CurrenciesEndpoint;
    @Value("${coinmarketcap.parameter.cmcrank}")
    private String sortByCmcRankParameter;
    @Value("${coinmarketcap.parameter.limit}")
    private String limitToListParameter;

    public CoinMarketCapListTop300Response listTop300ByCmcRank() throws RestClientResponseException {
        log.info("Initialize process to get top 300 of crypto currencies");
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
        log.info("build url to get top 300 cryptocurrencies");
        return urlBase
                .concat(listTop300CurrenciesEndpoint)
                .concat(INITIALIZE_URL_PARAMETER)
                .concat(sortByCmcRankParameter)
                .concat(NEXT_URL_PARAMETER_SYMBOL)
                .concat(limitToListParameter);
    }

    private boolean validateIfStatusResponseIsOK(ResponseEntity<CoinMarketCapListTop300Response> response) {
        return Objects.requireNonNull(response.getBody()).getStatus().getError_code() != 0;
    }
}
