package com.netcracker.courses.oe.inventory.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item")
@AttributeOverride(name = "id", column = @Column(name = "id_item"))
public class Item extends BaseEntity {

    private String idOffer;

    private String name;

    private double price;

    private String producer;

    private String category;

    private String barcode;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order")
    private Order order;

    public Item() {
    }

    public Item(String idOffer, String name, double price, String producer, String category, String barcode, Order order) {
        this.idOffer = idOffer;
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.category = category;
        this.barcode = barcode;
        this.order = order;
    }

    public String getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(String idOffer) {
        this.idOffer = idOffer;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 &&
                Objects.equals(idOffer, item.idOffer) &&
                Objects.equals(name, item.name) &&
                Objects.equals(producer, item.producer) &&
                Objects.equals(category, item.category) &&
                Objects.equals(barcode, item.barcode) &&
                Objects.equals(order, item.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idOffer, name, price, producer, category, barcode, order);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("idItem='").append(getId()).append('\'');
        sb.append("idOffer='").append(idOffer).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", producer='").append(producer).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", barcode='").append(barcode).append('\'');
        sb.append(", order=").append(order);
        sb.append('}');
        return sb.toString();
    }
}
