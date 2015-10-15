package ru.newpointer.currency.repository;

import ru.newpointer.currency.domain.Currency;

import java.time.LocalDate;
import java.util.Optional;

public interface CurrencyRepository {

    Optional<Currency> getCurrency(String code, LocalDate date);
}
