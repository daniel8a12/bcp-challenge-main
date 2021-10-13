package currencyexchange.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import currencyexchange.exchangerate.model.ExchangeRS;
import currencyexchange.exchangerate.model.ExchangeResponse;
import currencyexchange.exchangerate.service.ExchangeRateService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RequestMapping("/currency-exchange/v1.0/exchange-rate")
@RestController()
@Slf4j
@Validated
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    /**
     * Permite aplicar un tipo de cambio a un monto, te retorna el monto nuevo y el tipo de cambio aplicado.
     * @param amount
     * @param originCurrency
     * @param destinyCurrency
     * @return
     */
    @GetMapping(produces = { MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value = "Obtiene una lista de códigos BIN de las tarjetas.", 
    response = ExchangeResponse.class, httpMethod = "GET", 
    notes = "classpath:swagger/notes/ExchangeResponse.md")
    public Mono<ExchangeResponse> getConsultExchangeRate(@RequestParam(value = "amount", required = true) double amount,
                                                         @RequestParam(value = "origincurrency", required = true) int originCurrency,
                                                         @RequestParam(value = "destinycurrency", required = true) int destinyCurrency) {
        return exchangeRateService.getConsultExchangeRate(amount,originCurrency,destinyCurrency)
                .doFinally(x -> log.debug("FINALLY, MONO VALUE WAS: {}", x));
    }

    /**
     * Permite poder actualizar un tipo de cambio
     * @param currency
     * @return
     */
    @PostMapping(produces = { MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public Mono<Void> postConsultExchangeRate(@RequestBody ExchangeRS currency) {
        return exchangeRateService.postConsultExchangeRate(currency)
                .doFinally(x -> log.debug("FINALLY, MONO VALUE WAS: {}", x));
    }
}