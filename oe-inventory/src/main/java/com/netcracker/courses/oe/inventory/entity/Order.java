package com.netcracker.courses.oe.inventory.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "inv_order")
@AttributeOverride(name = "id", column = @Column(name = "id_order"))
public class Order extends BaseEntity {

    private String orderNumber;

    private String email;

    private double generalSum;

    private int amount;

    private String status;

    private LocalDateTime date;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items;

    public Order() {
    }

    public Order(String orderNumber, String email, double generalSum, int amount, String status, LocalDateTime date, List<Item> items) {
        this.orderNumber = orderNumber;
        this.email = email;
        this.generalSum = generalSum;
        this.amount = amount;
        this.status = status;
        this.date = date;
        this.items = items;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Double.compare(order.generalSum, generalSum) == 0 &&
                amount == order.amount &&
                Objects.equals(orderNumber, order.orderNumber) &&
                Objects.equals(email, order.email) &&
                Objects.equals(status, order.status) &&
                Objects.equals(date, order.date) &&
                Objects.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orderNumber, email, generalSum, amount, status, date, items);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("idOrder='").append(getId()).append('\'');
        sb.append("orderNumber='").append(orderNumber).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", generalSum=").append(generalSum);
        sb.append(", amount=").append(amount);
        sb.append(", status='").append(status).append('\'');
        sb.append(", date=").append(date);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
