package com.netcracker.courses.oe.inventory.repository;

import com.netcracker.courses.oe.inventory.entity.InvOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<InvOrder, Long> {
    List<InvOrder> findAllByEmail(String email);
}
