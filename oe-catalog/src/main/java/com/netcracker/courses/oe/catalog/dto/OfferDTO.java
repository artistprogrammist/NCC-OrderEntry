package com.netcracker.courses.oe.catalog.dto;

import java.util.List;
import java.util.Objects;

public class OfferDTO implements BaseEntityDTO {

    private long id;
    private String name;
    private double price;
    private String producer;
    private String category;
    private String barcode;
    private List<String> tags;

    public OfferDTO() {
    }

    public OfferDTO(long id, String name, double price, String producer, String category, String barcode, List<String> tags) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.category = category;
        this.barcode = barcode;
        this.tags = tags;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferDTO offerDTO = (OfferDTO) o;
        return id == offerDTO.id &&
                Double.compare(offerDTO.price, price) == 0 &&
                Objects.equals(name, offerDTO.name) &&
                Objects.equals(producer, offerDTO.producer) &&
                Objects.equals(category, offerDTO.category) &&
                Objects.equals(barcode, offerDTO.barcode) &&
                Objects.equals(tags, offerDTO.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, producer, category, barcode, tags);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OfferDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", producer='").append(producer).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", barcode='").append(barcode).append('\'');
        sb.append(", tags=").append(tags);
        sb.append('}');
        return sb.toString();
    }
}

