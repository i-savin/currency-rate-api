package ru.newpointer.currency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.newpointer.currency.domain.Currency;
import ru.newpointer.currency.repository.CurrencyRepository;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by isavin on 07.10.2015.
 */
@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository repository;

    public Optional<Currency> getCurrency(String code) {
        return repository.getCurrency(code, LocalDate.now().plusDays(1));
    }

    public Optional<Currency> getCurrency(String code, LocalDate date) {
        return repository.getCurrency(code, date);
    }
}
