package com.br.trabWeb.repository;

import com.br.trabWeb.models.Enums.RoleEnum;
import com.br.trabWeb.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}
