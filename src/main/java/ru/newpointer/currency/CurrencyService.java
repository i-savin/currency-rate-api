package ru.newpointer.currency;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by isavin on 30.09.15.
 */
public interface CurrencyService {

    public Optional<Currency> getCurrency(String code);

    public Optional<Currency> getCurrency(String code, LocalDate date);
}
