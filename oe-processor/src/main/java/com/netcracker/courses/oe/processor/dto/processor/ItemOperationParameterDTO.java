package com.netcracker.courses.oe.processor.dto.processor;

import com.netcracker.courses.oe.processor.dto.BaseEntityDTO;

import java.util.Objects;

public class ItemOperationParameterDTO implements BaseEntityDTO {

    private String email;
    private String orderNumber;
    private Long idItem;

    public ItemOperationParameterDTO() {
    }

    public ItemOperationParameterDTO(String email, String orderNumber, Long idItem) {
        this.email = email;
        this.orderNumber = orderNumber;
        this.idItem = idItem;
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

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemOperationParameterDTO that = (ItemOperationParameterDTO) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(orderNumber, that.orderNumber) &&
                Objects.equals(idItem, that.idItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, orderNumber, idItem);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ItemOperationParameterDTO{");
        sb.append("email='").append(email).append('\'');
        sb.append(", orderNumber='").append(orderNumber).append('\'');
        sb.append(", idItem=").append(idItem);
        sb.append('}');
        return sb.toString();
    }
}
