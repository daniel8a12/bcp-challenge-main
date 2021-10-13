package currencyexchange.exchangerate.service;

import currencyexchange.exchangerate.model.ExchangeRS;
import currencyexchange.exchangerate.model.ExchangeResponse;
import reactor.core.publisher.Mono;

public interface ExchangeRateService {

    Mono<ExchangeResponse> getConsultExchangeRate(double amount,
                                                         int originCurrency,
                                                         int destinyCurrency);
    
    Mono<Void> postConsultExchangeRate(ExchangeRS currency);

}
