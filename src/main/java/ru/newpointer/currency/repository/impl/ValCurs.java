package ru.newpointer.currency.repository.impl;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by isavin on 07.10.2015.
 */
@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValCurs {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "Date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate date;

    @XmlElement(name = "Valute")
    private List<Valute> valutes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Valute> getValutes() {
        return valutes;
    }

    public void setValutes(List<Valute> valutes) {
        this.valutes = valutes;
    }

    private static final class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

        private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        @Override
        public LocalDate unmarshal(String v) throws Exception {
            return LocalDate.parse(v, FORMATTER);
        }

        @Override
        public String marshal(LocalDate v) throws Exception {
            return v.format(FORMATTER);
        }
    }

    @Override
    public String toString() {
        return "ValCurs{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", valutes=" + valutes +
                '}';
    }
}
