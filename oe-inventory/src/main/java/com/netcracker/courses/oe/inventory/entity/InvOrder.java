package com.netcracker.courses.oe.inventory.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "inv_order")
@AttributeOverride(name = "id", column = @Column(name = "id_inv_order"))
public class InvOrder extends BaseEntity {

    private String email;

    private double generalSum;

    @OneToMany(mappedBy = "invOrder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InvItem> invItems;

    public InvOrder() {
    }

    public InvOrder(String email, double generalSum, String typeCurrency, List<InvItem> invItems) {
        this.email = email;
        this.generalSum = generalSum;
        this.invItems = invItems;
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

    public List<InvItem> getInvItems() {
        return invItems;
    }

    public void setInvItems(List<InvItem> invItems) {
        this.invItems = invItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InvOrder invOrder = (InvOrder) o;
        return Double.compare(invOrder.generalSum, generalSum) == 0 &&
                Objects.equals(email, invOrder.email) &&
                Objects.equals(invItems, invOrder.invItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, generalSum, invItems);
    }

    @Override
    public String
    toString() {
        final StringBuilder sb = new StringBuilder("InvOrder{");
        sb.append("email='").append(email).append('\'');
        sb.append(", generalSum=").append(generalSum);
        sb.append(", invItems=").append(invItems);
        sb.append('}');
        return sb.toString();
    }
}
