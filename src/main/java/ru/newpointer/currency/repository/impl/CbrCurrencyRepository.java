package ru.newpointer.currency.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.newpointer.currency.domain.Currency;
import ru.newpointer.currency.repository.CurrencyRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Repository
public class CbrCurrencyRepository implements CurrencyRepository {

    private final static Logger logger = LoggerFactory.getLogger(CbrCurrencyRepository.class);
    private final static String CBR_URL = "http://www.cbr.ru/scripts/XML_daily.asp?date_req={date}";
    private final static DateTimeFormatter cbrFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Optional<Currency> getCurrency(String code, LocalDate date) {

        logger.info("Getting currency for code [{}] and date [{}]", code, date);

        ValCurs valCurs = restTemplate.getForObject(CBR_URL, ValCurs.class, date.format(cbrFormatter));
        logger.info("ValCurs: {}", valCurs);
        Optional<Valute> valute = valCurs.getValutes().stream().filter((v) -> code.equals(v.getCharCode())).findFirst();
        if (!valute.isPresent()) {
            return Optional.empty();
        }
        logger.info("Valute: {}", valute);
        Currency currency = new Currency();
        currency.setCode(code);
        currency.setDate(valCurs.getDate());
        currency.setRate(valute.get().getValue().divide(BigDecimal.valueOf(valute.get().getNominal())));
        logger.info("Currency: {}", currency);

        return Optional.of(currency);
    }
}
