package com.modsen.pizzeria.repository;

import com.modsen.pizzeria.domain.Role;
import com.modsen.pizzeria.domain.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);

}
