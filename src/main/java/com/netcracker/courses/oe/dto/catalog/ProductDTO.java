package com.netcracker.courses.oe.dto.catalog;

import com.netcracker.courses.oe.dto.BaseEntityDTO;

import java.util.List;
import java.util.Objects;

public class ProductDTO implements BaseEntityDTO {

    private long id;
    private String name;
    private List<PriceDTO> prices;
    private long quantity;
    private String producer;
    private String category;
    private String barcode;

    public ProductDTO() {
    }

    public ProductDTO(long id, String name, List<PriceDTO> prices, long quantity, String producer, String category, String barcode) {
        this.id = id;
        this.name = name;
        this.prices = prices;
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

    public List<PriceDTO> getPrices() {
        return prices;
    }

    public void setPrices(List<PriceDTO> prices) {
        this.prices = prices;
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
        ProductDTO that = (ProductDTO) o;
        return id == that.id &&
                quantity == that.quantity &&
                Objects.equals(name, that.name) &&
                Objects.equals(prices, that.prices) &&
                Objects.equals(producer, that.producer) &&
                Objects.equals(category, that.category) &&
                Objects.equals(barcode, that.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, prices, quantity, producer, category, barcode);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", prices=").append(prices);
        sb.append(", quantity=").append(quantity);
        sb.append(", producer='").append(producer).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", barcode='").append(barcode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
