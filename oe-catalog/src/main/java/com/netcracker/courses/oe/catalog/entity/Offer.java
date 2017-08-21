package com.netcracker.courses.oe.catalog.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "offer")
@AttributeOverride(name = "id", column = @Column(name = "id_offer"))
public class Offer extends BaseEntity {

    private String name;

    private String producer;

    private String barcode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category")
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    private Price price;

    @ManyToMany(targetEntity = Tag.class, cascade = CascadeType.ALL)
    @JoinTable(name = "tag_offer", joinColumns = {@JoinColumn(name = "id_offer")},
            inverseJoinColumns = {@JoinColumn(name = "id_tag")})
    private List<Tag> tags;

    public Offer() {
    }

    public Offer(String name, String producer, String barcode, Category category, Price price, List<Tag> tags) {
        this.name = name;
        this.producer = producer;
        this.barcode = barcode;
        this.category = category;
        this.price = price;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Offer offer = (Offer) o;
        return Objects.equals(name, offer.name) &&
                Objects.equals(producer, offer.producer) &&
                Objects.equals(barcode, offer.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, producer, barcode);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Offer{");
        sb.append("id='").append(super.getId()).append('\'');
        sb.append("name='").append(name).append('\'');
        sb.append(", producer='").append(producer).append('\'');
        sb.append(", barcode='").append(barcode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
