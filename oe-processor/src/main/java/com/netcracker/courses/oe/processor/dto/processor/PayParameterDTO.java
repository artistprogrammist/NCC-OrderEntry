package com.netcracker.courses.oe.processor.dto.processor;

import com.netcracker.courses.oe.processor.dto.BaseEntityDTO;

import java.util.Objects;

public class PayParameterDTO implements BaseEntityDTO {

    private String email;
    private String orderNumber;

    public PayParameterDTO() {
    }

    public PayParameterDTO(String email, String orderNumber) {
        this.email = email;
        this.orderNumber = orderNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayParameterDTO that = (PayParameterDTO) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(orderNumber, that.orderNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, orderNumber);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PayParameterDTO{");
        sb.append("email='").append(email).append('\'');
        sb.append(", orderNumber='").append(orderNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
