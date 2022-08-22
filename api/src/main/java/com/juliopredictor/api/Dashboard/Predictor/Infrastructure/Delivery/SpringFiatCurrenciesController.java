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
        fiatCurrencies.add(new FiatCurrencies(1,"United States Dollar", "USD"));
        fiatCurrencies.add(new FiatCurrencies(2,"Argentine Peso", "ARS"));
        fiatCurrencies.add(new FiatCurrencies(3,"Australian Dollar", "AUD"));
        fiatCurrencies.add(new FiatCurrencies(4,"Canadian Dollar", "CAD"));
        fiatCurrencies.add(new FiatCurrencies(5,"Chilean Peso", "CLP"));
        fiatCurrencies.add(new FiatCurrencies(6,"Euro", "EUR"));
        fiatCurrencies.add(new FiatCurrencies(7,"New Zealand Dollar", "NZD"));
        fiatCurrencies.add(new FiatCurrencies(8,"Swiss Franc", "CHF"));
        return new RestResponse<>(HttpStatus.ACCEPTED, fiatCurrencies);
    }
}
