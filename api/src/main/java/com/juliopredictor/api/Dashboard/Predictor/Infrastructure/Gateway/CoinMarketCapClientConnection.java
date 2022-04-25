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
public class CoinMarketCapClientConnection {

    @Value("${coinmarketcap.credential.apikey}")
    private String apiKey;
    @Value("${coinmarketcap.credential.protocol}")
    private String headerProtocol;
    public final String INITIALIZE_URL_PARAMETER = "?";
    public final String NEXT_URL_PARAMETER_SYMBOL = "&";

    public RestTemplate instanceRestTemplate(){
        return new RestTemplate();
    }

    public HttpEntity<HttpHeaders> getHeadersWithCredentials() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set(headerProtocol,apiKey);
        return new HttpEntity<>(httpHeaders);
    }
}
