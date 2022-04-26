package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap;

import com.juliopredictor.api.Dashboard.Predictor.Domain.Model.UncalculatePrediction;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.requestDto.CoinMarketCapPredictorRequest;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.responseDto.CoinMarketCapEmbeddedToGetInformationResponse;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.responseDto.CoinMarketCapQuotesBaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CoinMarketCapClientHistoricalByCurrency extends CoinMarketCapClientConnection{

    @Value("${coinmarketcap.url.base}")
    private String urlBase;
    @Value("${coinmarketcap.url.historicalprice}")
    private String historicalPriceEndpoint;
    @Value("${coinmarketcap.url.info}")
    private String informationOfCryptoEndpoint;
    @Value("${coinmarketcap.parameter.currency}")
    private String currencyParameter;
    @Value("${coinmarketcap.parameter.cryptocurrency.id}")
    private String cryptoCurrencyParameter;

    public UncalculatePrediction getCurrencyWithPrediction(CoinMarketCapPredictorRequest coinMarketCapPredictorRequest){

        CoinMarketCapQuotesBaseResponse cryptoDataToPredict = getCryptoDataToPredict(coinMarketCapPredictorRequest);
        log.info("result of data to calculate");
        log.info(cryptoDataToPredict.toString());
        log.info(String.valueOf(cryptoDataToPredict.getData().get(coinMarketCapPredictorRequest.getCryptoId().toString()).getQuote()));
        /*
        log.info(String.valueOf(cryptoDataToPredict.getData().get(coinMarketCapPredictorRequest.getCryptoId().toString()).getQuote().getPrice()));
        log.info(String.valueOf(cryptoDataToPredict.getData().get(coinMarketCapPredictorRequest.getCryptoId().toString()).getQuote().getVolume_24h()));
        log.info(String.valueOf(cryptoDataToPredict.getData().get(coinMarketCapPredictorRequest.getCryptoId().toString()).getQuote().getVolume_change_24h()));
        log.info(String.valueOf(cryptoDataToPredict.getData().get(coinMarketCapPredictorRequest.getCryptoId().toString()).getQuote().getPercent_change_1h()));
        log.info(String.valueOf(cryptoDataToPredict.getData().get(coinMarketCapPredictorRequest.getCryptoId().toString()).getQuote().getPercent_change_24h()));
        log.info(String.valueOf(cryptoDataToPredict.getData().get(coinMarketCapPredictorRequest.getCryptoId().toString()).getQuote().getPercent_change_7d()));
        log.info(String.valueOf(cryptoDataToPredict.getData().get(coinMarketCapPredictorRequest.getCryptoId().toString()).getQuote().getPercent_change_30d()));
        log.info(String.valueOf(cryptoDataToPredict.getData().get(coinMarketCapPredictorRequest.getCryptoId().toString()).getQuote().getPercent_change_60d()));
        log.info(String.valueOf(cryptoDataToPredict.getData().get(coinMarketCapPredictorRequest.getCryptoId().toString()).getQuote().getPercent_change_90d()));
         */


        String cryptoCurrencyLogoById = getCryptoCurrencyLogoById(coinMarketCapPredictorRequest.getCryptoId());
        log.info("result of logo");
        log.info(cryptoCurrencyLogoById);

        return new UncalculatePrediction(cryptoDataToPredict, cryptoCurrencyLogoById);

    }

    public CoinMarketCapQuotesBaseResponse getCryptoDataToPredict(CoinMarketCapPredictorRequest coinMarketCapPredictorRequest){
        ResponseEntity<CoinMarketCapQuotesBaseResponse> historicalResponse = null;
        try {
            historicalResponse = instanceRestTemplate()
                    .exchange(getUrlToGetHistoricalPrice(coinMarketCapPredictorRequest),
                            HttpMethod.GET,
                            getHeadersWithCredentials(),
                            CoinMarketCapQuotesBaseResponse.class);
        }catch (Exception exception){
            log.error("Error", exception);
        }
        return historicalResponse.getBody();
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
                .concat(String.valueOf(coinMarketCapPredictorRequest.getCryptoId().intValue()));
    }

    private String getCryptoCurrencyLogoById(Long cryptoId){
        ResponseEntity<CoinMarketCapEmbeddedToGetInformationResponse> informationResponse = null;
        try {
            informationResponse = instanceRestTemplate()
                    .exchange(getUrlToGetCryptoCurrencyLogoById(cryptoId),
                            HttpMethod.GET,
                            getHeadersWithCredentials(),
                            CoinMarketCapEmbeddedToGetInformationResponse.class);
        }catch (Exception exception){
            log.error("Error", exception);
            throw new RuntimeException("Doesnt complete the call of API to get the logo of cryptoId: ".concat(cryptoId.toString()));
        }
        if(validateIfDontHasLogoUrl(informationResponse, cryptoId)){
            log.error("Doesnt have Logo");
            throw new RuntimeException("doesnt have Logo");
        }
        return informationResponse.getBody().getData().get(cryptoId.toString()).getLogo();
    }

    private String getUrlToGetCryptoCurrencyLogoById(Long cryptoId) {
        log.info("build url to get information of cryptocurrency to get icon");
        return urlBase
                .concat(informationOfCryptoEndpoint)
                .concat(INITIALIZE_URL_PARAMETER)
                .concat(cryptoCurrencyParameter)
                .concat(String.valueOf(cryptoId.intValue()));
    }

    private Boolean validateIfDontHasLogoUrl(ResponseEntity<CoinMarketCapEmbeddedToGetInformationResponse> informationResponse, Long cryptoId) {
        return (informationResponse.getBody() != null &&
                informationResponse.getBody().getData() != null &&
                informationResponse.getBody().getData().get(cryptoId.toString()).getLogo() != null) ?
                Boolean.FALSE :
                Boolean.TRUE;
    }
}
