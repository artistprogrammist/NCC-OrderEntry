package com.netcracker.courses.oe.dto.processor;

import com.netcracker.courses.oe.dto.BaseEntityDTO;

import java.util.Objects;

public class EntityParameterDTO implements BaseEntityDTO {

    private String email;
    private Long idItem;

    public EntityParameterDTO() {
    }

    public EntityParameterDTO(String email, Long idItem) {
        this.email = email;
        this.idItem = idItem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        EntityParameterDTO that = (EntityParameterDTO) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(idItem, that.idItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, idItem);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EntityParameterDTO{");
        sb.append("email='").append(email).append('\'');
        sb.append(", idItem=").append(idItem);
        sb.append('}');
        return sb.toString();
    }
}
