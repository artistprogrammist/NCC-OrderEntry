package com.netcracker.courses.oe.catalog.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "offer")
@AttributeOverride(name = "id", column = @Column(name = "id_offer"))
public class Offer extends BaseEntity {

    private String name;

    private double price;

    private String producer;

    private String barcode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category")
    private Category category;

    public Offer() {
    }

    public Offer(String name, double price, String producer, String barcode, Category category) {
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.barcode = barcode;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Offer offer = (Offer) o;
        return Double.compare(offer.price, price) == 0 &&
                Objects.equals(name, offer.name) &&
                Objects.equals(producer, offer.producer) &&
                Objects.equals(barcode, offer.barcode) &&
                Objects.equals(category, offer.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, price, producer, barcode, category);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Offer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", producer='").append(producer).append('\'');
        sb.append(", barcode='").append(barcode).append('\'');
        sb.append(", category=").append(category);
        sb.append('}');
        return sb.toString();
    }
}
