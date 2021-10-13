package currencyexchange.exchangerate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRequest {

    private String amount;
    private String finalAmount;
    private String originCurrency;
    private String destinyCurrency;
}
