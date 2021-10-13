package currencyexchange.exchangerate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeResponse {

    private double amount;
    private double finalAmount;
    private int originCurrency;
    private int destinyCurrency;
    private float currencyExchange;
}