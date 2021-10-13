package currencyexchange.exchangerate.service.impl;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import currencyexchange.exchangerate.dto.ExchangeRateDto;
import currencyexchange.exchangerate.model.ExchangeRS;
import currencyexchange.exchangerate.model.ExchangeResponse;
import currencyexchange.exchangerate.repository.ExchangeRepository;
import currencyexchange.exchangerate.service.ExchangeRateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@AllArgsConstructor
class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRepository exchangeRepository;


    /**
     * Permite aplicar un tipo de cambio a un monto, te retorna el monto nuevo y el tipo de cambio aplicado.
     * @param amount
     * @param originCurrency
     * @param destinyCurrency
     * @return
     */
    @Override
    public Mono<ExchangeResponse> getConsultExchangeRate(double amount,
                                                         int originCurrency,
                                                         int destinyCurrency) {
    	  return Mono.fromFuture(CompletableFuture.supplyAsync(() ->
    	  exchangeRepository.findByOriginCurrencyAndDestinyCurrency(originCurrency,destinyCurrency)))
    			  .doOnError(sub -> log.error("ERROR: {}", sub))
    			  .map(exchangeRateDTO -> convertResponse(exchangeRateDTO, amount, originCurrency, destinyCurrency));
    }

    /**
     * Permite convertir la respuesta de nuestra consulta a la respuesta de la api
     * @param exchangeRateDTO
     * @param amount
     * @param originCurrency
     * @param destinyCurrency
     * @return
     */
    private ExchangeResponse convertResponse(ExchangeRateDto exchangeRateDTO, double amount, int originCurrency, int destinyCurrency) {
        return new ExchangeResponse(amount,
                                    amount*exchangeRateDTO.getCurrencyExchange(),
                                    originCurrency,
                                    destinyCurrency,
                                    exchangeRateDTO.getCurrencyExchange());
    }


    /**
     * Permite poder actualizar un tipo de cambio
     * @param currency
     * @return
     */
    @Override
	public Mono<Void> postConsultExchangeRate(ExchangeRS currency) {
        return Mono.just(exchangeRepository.findByOriginCurrencyAndDestinyCurrency(currency.getOrigincurrency(), currency.getDestinycurrency()))
        		.doOnError(error -> log.error("ERROR: {}", error))
                .flatMap( r -> {
                    r.setCurrencyExchange(currency.getCurrency());
                    exchangeRepository.save(r);
                    return Mono.empty();
                });
	}
}
