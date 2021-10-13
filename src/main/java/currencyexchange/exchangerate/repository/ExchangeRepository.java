package currencyexchange.exchangerate.repository;

import currencyexchange.exchangerate.dto.ExchangeRateDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends CrudRepository<ExchangeRateDto, Integer> {

    public ExchangeRateDto findByOriginCurrencyAndDestinyCurrency(int originCurrency, int destinyCurrency);
}
