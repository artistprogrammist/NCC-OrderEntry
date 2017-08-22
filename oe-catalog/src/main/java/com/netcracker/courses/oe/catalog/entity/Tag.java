package com.netcracker.courses.oe.catalog.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tag", indexes = {@Index(name = "idx_tag_name", columnList = "name")})
@AttributeOverride(name = "id", column = @Column(name = "id_tag"))
public class Tag extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Offer> offers;

    public Tag() {
    }

    public Tag(String name, List<Offer> offers) {
        this.name = name;
        this.offers = offers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tag tag = (Tag) o;
        return Objects.equals(name, tag.name) &&
                Objects.equals(offers, tag.offers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, offers);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TagDTO{");
        sb.append("id='").append(super.getId()).append('\'');
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
