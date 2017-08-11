package com.netcracker.courses.oe.entity.inventory;

import com.netcracker.courses.oe.entity.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item")
@AttributeOverride(name = "id", column = @Column(name = "id_item"))
public class InvItem extends BaseEntity {

    private String name;

    private double price;

    private String producer;

    private String category;

    private String barcode;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inv_order")
    private InvOrder invOrder;

    public InvItem() {
    }

    public InvItem(String name, double price, String producer, String category, String barcode, InvOrder invOrder) {
        this.name = name;
        this.price = price;
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
        if (!super.equals(o)) return false;
        InvItem invItem = (InvItem) o;
        return Double.compare(invItem.price, price) == 0 &&
                Objects.equals(name, invItem.name) &&
                Objects.equals(producer, invItem.producer) &&
                Objects.equals(category, invItem.category) &&
                Objects.equals(barcode, invItem.barcode) &&
                Objects.equals(invOrder, invItem.invOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, price, producer, category, barcode, invOrder);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InvItem{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", producer='").append(producer).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", barcode='").append(barcode).append('\'');
        sb.append(", invOrder=").append(invOrder);
        sb.append('}');
        return sb.toString();
    }
}
