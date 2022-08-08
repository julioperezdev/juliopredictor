package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Delivery;

import com.juliopredictor.api.Dashboard.Predictor.Domain.Model.FiatCurrencies;
import com.juliopredictor.api.Shared.Infrastructure.Delivery.RestResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/currencies")
@AllArgsConstructor
@Slf4j
public class SpringFiatCurrenciesController {

    @GetMapping("/fiat")
    public RestResponse<List<FiatCurrencies>> getEnablesFiatCurrencies(){
        log.info("has been calling getEnablesFiatCurrencies");
        List<FiatCurrencies> fiatCurrencies = new ArrayList<>();
        fiatCurrencies.add(new FiatCurrencies("United States Dollar", "USD"));
        fiatCurrencies.add(new FiatCurrencies("Argentine Peso", "ARS"));
        fiatCurrencies.add(new FiatCurrencies("Australian Dollar", "AUD"));
        fiatCurrencies.add(new FiatCurrencies("Canadian Dollar", "CAD"));
        fiatCurrencies.add(new FiatCurrencies("Chilean Peso", "CLP"));
        fiatCurrencies.add(new FiatCurrencies("Euro", "EUR"));
        fiatCurrencies.add(new FiatCurrencies("New Zealand Dollar", "NZD"));
        fiatCurrencies.add(new FiatCurrencies("Swiss Franc", "CHF"));
        return new RestResponse<>(HttpStatus.ACCEPTED, fiatCurrencies);
    }
}
