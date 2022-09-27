package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {

    @Autowired
    private Environment environment;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CurrencyExchangeProxy proxy;

    // Below End point uses Rest Template to connect with other microservice end point

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
                                                          @PathVariable String to,
                                                          @PathVariable BigDecimal quantity) {
      /*  String port = environment.getProperty("local.server.port");

        return new CurrencyConversion(10001L,
                from, to, quantity,
                BigDecimal.ONE,
                BigDecimal.ONE,
                port);*/

        HashMap<String, String> uriVariables = new HashMap<>();

        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversion> response = restTemplate.getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables
        );

        CurrencyConversion currencyConversion = response.getBody();

        CurrencyConversion res = null;
        if (currencyConversion != null) {
            res = new CurrencyConversion(currencyConversion.getId(),
                    from, to, quantity, currencyConversion.getConversionMultiple(),
                    quantity.multiply(currencyConversion.getConversionMultiple()),
                    currencyConversion.getEnvironment() + " Rest");
        }
        return res;
    }

    // below end point uses Feign Client to connect with other microservices end point
    // we are calling retrieveExchangeValue method defined in feign proxy class

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ) {

        CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);

        return new CurrencyConversion(currencyConversion.getId(),
                from, to, quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment() + " " + "Feign");

    }
}
