package com.br.trabWeb.controllers;

import com.br.trabWeb.models.Projeto;
import com.br.trabWeb.models.Usuario;
import com.br.trabWeb.payload.requestDTO.ProjetoDeleteDTO;
import com.br.trabWeb.payload.requestDTO.ProjetoEditRequestDTO;
import com.br.trabWeb.payload.requestDTO.ProjetoRequestDTO;
import com.br.trabWeb.repository.ProjetoRepository;
import com.br.trabWeb.repository.UsuarioRepository;
import com.br.trabWeb.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

// @CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/projetos")
public class ProjectController {
    @Autowired
    UserService userService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ProjetoRepository projetoRepository;

    /* Create */
    @PostMapping("/addProject")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> addProject(@Valid @RequestBody ProjetoRequestDTO projetoRequestDTO) throws Exception {
        try {
            String username = this.userService.getTokenFromUser();
            if (Objects.isNull(username)) {
                //to do
            }

            Long userId = this.usuarioRepository.findUsuarioByUsername(username);
            Usuario usuario = this.usuarioRepository.findUsuarioById(userId);

            Projeto projeto = new Projeto();

            projeto.setUsuario(usuario);
            projeto.setTitulo(projetoRequestDTO.getTitulo());
            projeto.setDescricao(projetoRequestDTO.getDescricao());
            projeto.setAutores(projetoRequestDTO.getAutores());
            projeto.setData(LocalDateTime.now());
            projeto.setFotoUrl(projetoRequestDTO.getFotoUrl());
            projeto.setLinkRepositorio(projetoRequestDTO.getLinkRepositorio());

            this.projetoRepository.save(projeto);

            return ResponseEntity.ok("Ok");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /* Update */
    @PostMapping("/updateProject")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> editProject(@Valid @RequestBody ProjetoEditRequestDTO projetoEditRequestDTO) throws Exception {
        try {
            String username = this.userService.getTokenFromUser();
            if (Objects.isNull(username)) {
                //to do
            }

            Long userId = this.usuarioRepository.findUsuarioByUsername(username);
            Usuario usuario = this.usuarioRepository.findUsuarioById(userId);

            Projeto projeto = new Projeto();

            projeto.setId(projetoEditRequestDTO.getProjetoId());
            projeto.setUsuario(usuario);
            projeto.setTitulo(projetoEditRequestDTO.getTitulo());
            projeto.setDescricao(projetoEditRequestDTO.getDescricao());
            projeto.setAutores(projetoEditRequestDTO.getAutores());
            projeto.setData(LocalDateTime.now());
            projeto.setFotoUrl(projetoEditRequestDTO.getFotoUrl());
            projeto.setLinkRepositorio(projetoEditRequestDTO.getLinkRepositorio());

            this.projetoRepository.save(projeto);

            return ResponseEntity.ok("Ok");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    /* Read */
    @GetMapping("/getProjects")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Projeto> getProjects() throws Exception {
        try {
            String username = this.userService.getTokenFromUser();
            if (Objects.isNull(username)) {
                //to do
            }

            Long userId = this.usuarioRepository.findUsuarioByUsername(username);
            Usuario usuario = this.usuarioRepository.findUsuarioById(userId);

            return this.projetoRepository.findAllByUsuario(usuario);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /* Delete */
    @DeleteMapping("/deleteProject")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteProject(@Valid @RequestBody ProjetoDeleteDTO projetoDeleteDTO) throws Exception {
        try {
            String username = this.userService.getTokenFromUser();
            if (Objects.isNull(username)) {
                //to do
            }

            this.projetoRepository.deleteById(projetoDeleteDTO.getProjectId());

            return ResponseEntity.ok("Ok");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /* getAll em projetos */
    @GetMapping("/getAll")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Projeto> getAllProjects() throws Exception {
        try {
            String username = this.userService.getTokenFromUser();
            if (Objects.isNull(username)) {
                //to do
            }

            Long userId = this.usuarioRepository.findUsuarioByUsername(username);
            Usuario usuario = this.usuarioRepository.findUsuarioById(userId);

            return this.projetoRepository.findAll();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/getProjects/{user}")
    public List<Projeto> getProjectsUser(@PathVariable String user) throws Exception {
        try {
            Long userId = this.usuarioRepository.findUsuarioByUsername(user);
            Usuario usuario = this.usuarioRepository.findUsuarioById(userId);

            return this.projetoRepository.findAllByUsuario(usuario);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
