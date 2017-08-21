package com.netcracker.courses.oe.catalog.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "price")
@AttributeOverride(name = "id", column = @Column(name = "id_price"))
public class Price extends BaseEntity {

    private double currencyValue;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Offer offer;

    public Price() {
    }

    public Price(double currencyValue, Offer offer) {
        this.currencyValue = currencyValue;
        this.offer = offer;
    }

    public double getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(double currencyValue) {
        this.currencyValue = currencyValue;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Price price = (Price) o;
        return Double.compare(price.currencyValue, currencyValue) == 0 &&
                Objects.equals(offer, price.offer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currencyValue, offer);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Price{");
        sb.append("id='").append(super.getId()).append('\'');
        sb.append("currencyValue=").append(currencyValue);
        sb.append('}');
        return sb.toString();
    }
}
