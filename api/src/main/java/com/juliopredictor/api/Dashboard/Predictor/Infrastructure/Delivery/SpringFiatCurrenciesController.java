package com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Delivery;

import com.juliopredictor.api.Shared.Infrastructure.Delivery.RestResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/currencies")
@AllArgsConstructor
public class SpringFiatCurrenciesController {

    @GetMapping("/fiat")
    public RestResponse<Map<String, String>> getEnablesFiatCurrencies(){
        Map<String, String> enableFiatCurrencies = new HashMap<>();
        enableFiatCurrencies.put("United States Dollar", "USD");
        enableFiatCurrencies.put("Argentine Peso", "ARS");
        enableFiatCurrencies.put("Australian Dollar", "AUD");
        enableFiatCurrencies.put("Canadian Dollar", "CAD");
        enableFiatCurrencies.put("Chilean Peso", "CLP");
        enableFiatCurrencies.put("Euro", "EUR");
        enableFiatCurrencies.put("New Zealand Dollar", "NZD");
        enableFiatCurrencies.put("Swiss Franc", "CHF");
        return new RestResponse<>(HttpStatus.ACCEPTED, enableFiatCurrencies);
    }
}
