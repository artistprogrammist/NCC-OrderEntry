package com.netcracker.courses.oe.user.repository;

import com.netcracker.courses.oe.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findFirstByName(String name);
}
