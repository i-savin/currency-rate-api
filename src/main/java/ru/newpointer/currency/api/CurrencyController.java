package ru.newpointer.currency.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.newpointer.currency.domain.Currency;
import ru.newpointer.currency.service.CurrencyService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * @author isavin
 */
@RestController
public class CurrencyController {

    private final static Logger logger = LoggerFactory.getLogger(CurrencyController.class);

    @Autowired
    private CurrencyService currencyService;

    @RequestMapping("/currency/api/{code}")
    public ResponseEntity<Currency> currency(@PathVariable String code) {
        logger.info("Getting currency rate for: [{}]", code);
        LocalDate date = LocalDate.now().plusDays(1);
        return toEntity(currencyService.getCurrency(code, date));
    }

    @RequestMapping("/currency/api/{code}/{date}")
    public ResponseEntity<Currency> currency(@PathVariable String code,
                             @PathVariable String date) {
        logger.info("Getting currency rate for: [{}, {}]", code, date);
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            return toEntity(Optional.empty());
        }
        return toEntity(currencyService.getCurrency(code, localDate));
    }

    private <T> ResponseEntity<T> toEntity(Optional<T> body) {
        if (body.isPresent()) {
            return new ResponseEntity<T>(body.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
