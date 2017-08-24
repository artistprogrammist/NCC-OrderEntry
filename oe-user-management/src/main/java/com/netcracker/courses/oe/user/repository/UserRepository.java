package com.netcracker.courses.oe.user.repository;

import com.netcracker.courses.oe.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
