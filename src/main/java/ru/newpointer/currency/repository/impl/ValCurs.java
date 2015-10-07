package ru.newpointer.currency.repository.impl;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by isavin on 07.10.2015.
 */
@XmlRootElement(name = "ValCurs")
public class ValCurs {
    @XmlAttribute(name = "Name")
    private String name;
    @XmlAttribute(name = "Date")
    private LocalDate date;

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
}
