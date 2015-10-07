package ru.newpointer.currency.repository;

import ru.newpointer.currency.domain.Currency;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by isavin on 07.10.2015.
 */
public interface CurrencyRepository {

    public Optional<Currency> getCurrency(String code, LocalDate date);
}
