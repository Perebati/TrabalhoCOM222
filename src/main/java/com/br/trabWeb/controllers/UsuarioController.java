package com.br.trabWeb.controllers;

import com.br.trabWeb.models.Usuario;
import com.br.trabWeb.payload.requestDTO.UsuarioEditDTO;
import com.br.trabWeb.repository.ProjetoRepository;
import com.br.trabWeb.repository.UsuarioRepository;
import com.br.trabWeb.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    UserService userService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ProjetoRepository projetoRepository;

    @Autowired
    PasswordEncoder encoder;

    /* Update */
    @PostMapping("/updateUser")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UsuarioEditDTO usuarioEditDTO) throws Exception {
        try {
            String username = this.userService.getTokenFromUser();
            if (Objects.isNull(username)) {
                //to do
            }

            Long userId = this.usuarioRepository.findUsuarioByUsername(username);
            Usuario usuario = this.usuarioRepository.findUsuarioById(userId);

            usuario.setBio(usuarioEditDTO.getBio());
            usuario.setFacebook(usuarioEditDTO.getFacebook());
            usuario.setGithub(usuarioEditDTO.getGithub());
            usuario.setLinkedin(usuarioEditDTO.getLinkedin());
            usuario.setInstagram(usuarioEditDTO.getInstagram());
            usuario.setFotoUrl(usuarioEditDTO.getFotoUrl());

            this.usuarioRepository.save(usuario);

            return ResponseEntity.ok("Ok");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /* Password edit */
    @PostMapping("/updatePassword")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> updatePassword(@Valid @RequestParam String usuarioPasswordEditDTO) throws Exception {
        try {
            String username = this.userService.getTokenFromUser();
            if (Objects.isNull(username)) {
                //to do
            }

            Long userId = this.usuarioRepository.findUsuarioByUsername(username);
            Usuario usuario = this.usuarioRepository.findUsuarioById(userId);

            usuario.setPassword(encoder.encode(usuarioPasswordEditDTO));

            this.usuarioRepository.save(usuario);

            return ResponseEntity.ok("Ok");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /* Read */
    @GetMapping("/getUserData")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Usuario getProjects() throws Exception {
        try {
            String username = this.userService.getTokenFromUser();
            if (Objects.isNull(username)) {
                //to do
            }

            Long userId = this.usuarioRepository.findUsuarioByUsername(username);
            return this.usuarioRepository.findUsuarioById(userId);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /* getAll em usuario */
    @GetMapping("/getAllUsers")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Usuario> getUsers() throws Exception {
        try {
            String username = this.userService.getTokenFromUser();
            if (Objects.isNull(username)) {
                //to do
            }

            return this.usuarioRepository.findAll();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /* Delete */
    @DeleteMapping("/deleteUser")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@Valid @RequestParam Long userId) throws Exception {
        try {
            String username = this.userService.getTokenFromUser();
            if (Objects.isNull(username)) {
                //to do
            }

            this.usuarioRepository.deleteById(userId);

            return ResponseEntity.ok("Ok");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
