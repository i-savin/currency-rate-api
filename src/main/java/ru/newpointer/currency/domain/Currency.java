package ru.newpointer.currency.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author isavin
 */
public class Currency {

    private String code;
    private BigDecimal rate;
    private LocalDate date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public LocalDate BigDecimal() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = LocalDate.from(date);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", rate='" + rate + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
