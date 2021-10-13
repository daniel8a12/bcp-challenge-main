package currencyexchange.exchangerate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CURRENCYEXCHANGE")
public class ExchangeRateDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int id;
    @Column(name = "CODORIGINCURRENCY")
    private int originCurrency;
    @Column(name = "CODDESTINYCURRENCY")
    private int destinyCurrency;
    @Column(name = "CURRENCYEXCHANGE")
    private float currencyExchange;
}