package com.br.trabWeb.repository;

import com.br.trabWeb.models.Projeto;
import com.br.trabWeb.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    List<Projeto> findAllByUsuario(Usuario user);

    void deleteById(Long projectId);
}
