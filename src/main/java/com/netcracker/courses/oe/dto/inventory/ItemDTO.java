package com.netcracker.courses.oe.dto.inventory;

import com.netcracker.courses.oe.dto.BaseEntityDTO;

import java.util.Objects;

public class ItemDTO implements BaseEntityDTO {

    private long id;
    private String name;
    private double currencyValue;
    private String currency;
    private long quantity;
    private String producer;
    private String category;
    private String barcode;

    public ItemDTO() {
    }

    public ItemDTO(long id, String name, double currencyValue, String currency, long quantity, String producer, String category, String barcode) {
        this.id = id;
        this.name = name;
        this.currencyValue = currencyValue;
        this.currency = currency;
        this.quantity = quantity;
        this.producer = producer;
        this.category = category;
        this.barcode = barcode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return id == itemDTO.id &&
                Double.compare(itemDTO.currencyValue, currencyValue) == 0 &&
                quantity == itemDTO.quantity &&
                Objects.equals(name, itemDTO.name) &&
                Objects.equals(currency, itemDTO.currency) &&
                Objects.equals(producer, itemDTO.producer) &&
                Objects.equals(category, itemDTO.category) &&
                Objects.equals(barcode, itemDTO.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, currencyValue, currency, quantity, producer, category, barcode);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ItemDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", currencyValue=").append(currencyValue);
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", producer='").append(producer).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", barcode='").append(barcode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
