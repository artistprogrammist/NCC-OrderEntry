package com.netcracker.courses.oe.repository.inventory;

import com.netcracker.courses.oe.entity.inventory.InvOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<InvOrder, Long> {
    List<InvOrder> findAllByEmail(String email);
}
