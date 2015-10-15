package ru.newpointer.currency.repository;

import org.springframework.stereotype.Repository;
import ru.newpointer.currency.domain.Currency;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by isavin on 07.10.2015.
 */
public interface CurrencyRepository {

    public Optional<Currency> getCurrency(String code, LocalDate date);
}
