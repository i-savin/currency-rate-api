package ru.newpointer.currency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.newpointer.currency.repository.CurrencyRepository;
import ru.newpointer.currency.repository.impl.CbrCurrencyRepository;

@SpringBootApplication
public class Application {

    @Bean
    public CurrencyRepository currencyRepository() {
        CurrencyRepository repository = new CbrCurrencyRepository();
        return repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}