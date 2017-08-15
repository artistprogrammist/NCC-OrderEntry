package com.netcracker.courses.oe.inventory.dto;


import java.util.List;
import java.util.Objects;

public class InvOrderDTO implements BaseEntityDTO {

    private long id;
    private String email;
    private List<InvItemDTO> items;
    private double generalSum;

    public InvOrderDTO() {
    }

    public InvOrderDTO(long id, String email, List<InvItemDTO> items, double generalSum) {
        this.id = id;
        this.email = email;
        this.items = items;
        this.generalSum = generalSum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<InvItemDTO> getItems() {
        return items;
    }

    public void setItems(List<InvItemDTO> items) {
        this.items = items;
    }

    public double getGeneralSum() {
        return generalSum;
    }

    public void setGeneralSum(double generalSum) {
        this.generalSum = generalSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvOrderDTO that = (InvOrderDTO) o;
        return id == that.id &&
                Double.compare(that.generalSum, generalSum) == 0 &&
                Objects.equals(email, that.email) &&
                Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, items, generalSum);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InvOrderDTO{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", items=").append(items);
        sb.append(", generalSum=").append(generalSum);
        sb.append('}');
        return sb.toString();
    }
}
