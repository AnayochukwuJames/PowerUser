package org.example.poweruser.repository;

import org.example.poweruser.model.PowerUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PowerUserRepository extends JpaRepository<PowerUser, Integer> {
    Optional<PowerUser> findByFirstName(String name);
    Optional<PowerUser> findByPhoneNumber(String name);
}
