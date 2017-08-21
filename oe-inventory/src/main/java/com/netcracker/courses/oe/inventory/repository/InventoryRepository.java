package com.netcracker.courses.oe.inventory.repository;

import com.netcracker.courses.oe.inventory.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByEmail(String email);
}
