package currencyexchange.exchangerate.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ExchangeRateProperties {

    //@Value("${application.change-data.exchange-rate.trx-code}")
    private String trxCode;
}