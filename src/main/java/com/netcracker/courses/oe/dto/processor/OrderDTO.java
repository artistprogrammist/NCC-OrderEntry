package com.netcracker.courses.oe.dto.processor;

import com.netcracker.courses.oe.dto.BaseEntityDTO;
import com.netcracker.courses.oe.dto.inventory.ItemDTO;

import java.util.List;
import java.util.Objects;

public class OrderDTO implements BaseEntityDTO {
    private long id;
    private String email;
    private List<ItemDTO> items;

    public OrderDTO() {
    }

    public OrderDTO(long id, String email, List<ItemDTO> items) {
        this.id = id;
        this.email = email;
        this.items = items;
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
                Objects.equals(email, orderDTO.email) &&
                Objects.equals(items, orderDTO.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, items);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
