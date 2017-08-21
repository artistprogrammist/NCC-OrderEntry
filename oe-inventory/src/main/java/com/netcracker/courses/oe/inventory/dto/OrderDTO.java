package com.netcracker.courses.oe.inventory.dto;

import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Objects;

public class OrderDTO implements BaseEntityDTO {

    private long id;
    private String orderNumber;
    private String email;
    private double generalSum;
    private int amount;
    private String date;
    private List<ItemDTO> items;

    public OrderDTO() {
    }

    public OrderDTO(long id, String orderNumber, String email, double generalSum, int amount, String date, List<ItemDTO> items) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.email = email;
        this.generalSum = generalSum;
        this.amount = amount;
        this.date = date;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        return id == orderDTO.id &&
                Double.compare(orderDTO.generalSum, generalSum) == 0 &&
                amount == orderDTO.amount &&
                Objects.equals(orderNumber, orderDTO.orderNumber) &&
                Objects.equals(email, orderDTO.email) &&
                Objects.equals(date, orderDTO.date) &&
                Objects.equals(items, orderDTO.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNumber, email, generalSum, amount, date, items);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderDTO{");
        sb.append("id=").append(id);
        sb.append(", orderNumber='").append(orderNumber).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", generalSum=").append(generalSum);
        sb.append(", amount=").append(amount);
        sb.append(", date='").append(date).append('\'');
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
