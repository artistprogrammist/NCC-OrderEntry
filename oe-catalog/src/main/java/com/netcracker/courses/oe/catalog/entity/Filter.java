package com.netcracker.courses.oe.catalog.entity;

import java.io.Serializable;
import java.util.List;

public class Filter implements Serializable, Cloneable {

    private Category category;

    private Double priceFrom;

    private Double priceTo;

    private List<Tag> tags;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Double priceTo) {
        this.priceTo = priceTo;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
