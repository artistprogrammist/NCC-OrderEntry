package com.netcracker.courses.oe.entity.catalog;

import com.netcracker.courses.oe.entity.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "price")
@AttributeOverride(name = "id", column = @Column(name = "id_price"))
public class Price extends BaseEntity {

    private double currencyValue;

    private String currency;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product")
    private Product product;

    public Price() {
    }

    public Price(double currencyValue, String currency, Product product) {
        this.currencyValue = currencyValue;
        this.currency = currency;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Price price = (Price) o;
        return Double.compare(price.currencyValue, currencyValue) == 0 &&
                Objects.equals(currency, price.currency) &&
                Objects.equals(product, price.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currencyValue, currency, product);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Price{");
        sb.append("currencyValue='").append(currencyValue).append('\'');
        sb.append(", currency=").append(currency);
        sb.append('}');
        return sb.toString();
    }
}
