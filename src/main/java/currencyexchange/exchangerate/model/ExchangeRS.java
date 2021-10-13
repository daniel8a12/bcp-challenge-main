package currencyexchange.exchangerate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRS {
	
	private Integer origincurrency;
	private Integer destinycurrency;
	private float currency;

}
