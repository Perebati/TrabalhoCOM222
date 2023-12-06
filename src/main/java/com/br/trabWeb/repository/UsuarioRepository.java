package com.br.trabWeb.repository;

import com.br.trabWeb.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query(value = "SELECT u.id FROM Usuario u WHERE u.username = :username")
    Long findUsuarioByUsername(@Param("username") String username);

    Usuario findUsuarioById(Long userId);
}
