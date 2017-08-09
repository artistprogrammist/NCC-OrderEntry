package com.netcracker.courses.oe.dto.catalog;

import com.netcracker.courses.oe.dto.BaseEntityDTO;

import java.util.Objects;

public class PriceDTO implements BaseEntityDTO {

    private double currencyValue;

    private String currency;

    public PriceDTO() {
    }

    public PriceDTO(double currencyValue, String currency) {
        this.currencyValue = currencyValue;
        this.currency = currency;
    }

    public double getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(double currencyValue) {
        this.currencyValue = currencyValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceDTO priceDTO = (PriceDTO) o;
        return Double.compare(priceDTO.currencyValue, currencyValue) == 0 &&
                Objects.equals(currency, priceDTO.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyValue, currency);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PriceDTO{");
        sb.append("currencyValue=").append(currencyValue);
        sb.append(", currency='").append(currency).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
