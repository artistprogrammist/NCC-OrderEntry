package com.netcracker.courses.oe.dto.processor;

import com.netcracker.courses.oe.dto.BaseEntityDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderDTO implements BaseEntityDTO {

    private String email;
    private double generalSum;
    private List<ItemDTO> items = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(String email, double generalSum, String typeCurrency, List<ItemDTO> items) {
        this.email = email;
        this.generalSum = generalSum;
        this.items = items;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGeneralSum() {
        return generalSum;
    }

    public void setGeneralSum(double generalSum) {
        this.generalSum = generalSum;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Double.compare(orderDTO.generalSum, generalSum) == 0 &&
                Objects.equals(email, orderDTO.email) &&
                Objects.equals(items, orderDTO.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, generalSum, items);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderDTO{");
        sb.append("email='").append(email).append('\'');
        sb.append(", generalSum=").append(generalSum);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
