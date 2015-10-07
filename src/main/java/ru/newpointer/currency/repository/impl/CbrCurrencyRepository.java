package ru.newpointer.currency.repository.impl;

import org.springframework.web.client.RestTemplate;
import ru.newpointer.currency.domain.Currency;
import ru.newpointer.currency.repository.CurrencyRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * Created by isavin on 07.10.2015.
 */
public class CbrCurrencyRepository implements CurrencyRepository {

    private final static String CBR_URL = "http://www.cbr.ru/scripts/XML_daily.asp?date_req={date}";
    private final static DateTimeFormatter cbrFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private RestTemplate restTemplate;

    @Override
    public Optional<Currency> getCurrency(String code, LocalDate date) {

        ValCurs valCurs = restTemplate.getForObject(CBR_URL, ValCurs.class, date.format(cbrFormatter));
        Optional<Valute> valute = valCurs.getValutes().stream().filter((v) -> code.equals(v.getCharCode())).findFirst();
        if (!valute.isPresent()) {
            return Optional.empty();
        }

        Currency currency = new Currency();
        currency.setCode(valute.get().getCharCode());
        currency.setDate(date);
        currency.setRate(valute.get().getValue().divide(BigDecimal.valueOf(valute.get().getNominal())));

        return Optional.of(currency);
    }
}
