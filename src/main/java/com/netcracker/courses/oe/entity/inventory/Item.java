package com.netcracker.courses.oe.entity.inventory;

import com.netcracker.courses.oe.entity.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item")
@AttributeOverride(name = "id", column = @Column(name = "id_item"))
public class Item extends BaseEntity {

    private String name;

    private double currencyValue;

    private String currency;

    private long quantity;

    private String producer;

    private String category;

    private String barcode;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inv_order")
    private InvOrder invOrder;

    public Item() {
    }

    public Item(String name, double currencyValue, String currency, long quantity, String producer, String category, String barcode, InvOrder invOrder) {
        this.name = name;
        this.currencyValue = currencyValue;
        this.currency = currency;
        this.quantity = quantity;
        this.producer = producer;
        this.category = category;
        this.barcode = barcode;
        this.invOrder = invOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public InvOrder getInvOrder() {
        return invOrder;
    }

    public void setInvOrder(InvOrder invOrder) {
        this.invOrder = invOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item itemDTO = (Item) o;
        return quantity == itemDTO.quantity &&
                Objects.equals(name, itemDTO.name) &&
                Objects.equals(currencyValue, itemDTO.currencyValue) &&
                Objects.equals(currency, itemDTO.currency) &&
                Objects.equals(producer, itemDTO.producer) &&
                Objects.equals(category, itemDTO.category) &&
                Objects.equals(barcode, itemDTO.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, currencyValue, currency, quantity, producer, category, barcode);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append(", name='").append(name).append('\'');
        sb.append(", currencyValue='").append(currencyValue).append('\'');
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", producer='").append(producer).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", barcode='").append(barcode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
