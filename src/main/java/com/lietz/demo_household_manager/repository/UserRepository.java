package com.lietz.demo_household_manager.repository;

import com.lietz.demo_household_manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
