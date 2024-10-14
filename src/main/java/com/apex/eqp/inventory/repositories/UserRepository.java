package com.apex.eqp.inventory.repositories;

import com.apex.eqp.inventory.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
