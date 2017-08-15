package com.netcracker.courses.oe.processor.dto.processor;

import com.netcracker.courses.oe.processor.dto.BaseEntityDTO;

import java.util.Objects;

public class ItemDTO implements BaseEntityDTO {

    private long id;
    private String name;
    private double price;
    private String producer;
    private String category;
    private String barcode;

    public ItemDTO() {
    }

    public ItemDTO(long id, String name, double price, String producer, String category, String barcode) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return id == itemDTO.id &&
                Double.compare(itemDTO.price, price) == 0 &&
                Objects.equals(name, itemDTO.name) &&
                Objects.equals(producer, itemDTO.producer) &&
                Objects.equals(category, itemDTO.category) &&
                Objects.equals(barcode, itemDTO.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, producer, category, barcode);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ItemDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", producer='").append(producer).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", barcode='").append(barcode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
