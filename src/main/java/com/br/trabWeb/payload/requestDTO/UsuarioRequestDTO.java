package com.br.trabWeb.payload.requestDTO;

public class UsuarioRequestDTO {
    private Long id;
    private String nome;

    private String senha;

    private String email;

    private String bio;

    private String linkGithub;

    private String linkLinkedin;

    private String linkInstagram;

    private String linkFacebook;

    private String fotoUrl;

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(Long id, String nome, String senha, String email, String bio, String linkGithub, String linkLinkedin, String linkInstagram, String linkFacebook, String fotoUrl) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.bio = bio;
        this.linkGithub = linkGithub;
        this.linkLinkedin = linkLinkedin;
        this.linkInstagram = linkInstagram;
        this.linkFacebook = linkFacebook;
        this.fotoUrl = fotoUrl;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLinkGithub() {
        return linkGithub;
    }

    public void setLinkGithub(String linkGithub) {
        this.linkGithub = linkGithub;
    }

    public String getLinkLinkedin() {
        return linkLinkedin;
    }

    public void setLinkLinkedin(String linkLinkedin) {
        this.linkLinkedin = linkLinkedin;
    }

    public String getLinkInstagram() {
        return linkInstagram;
    }

    public void setLinkInstagram(String linkInstagram) {
        this.linkInstagram = linkInstagram;
    }

    public String getLinkFacebook() {
        return linkFacebook;
    }

    public void setLinkFacebook(String linkFacebook) {
        this.linkFacebook = linkFacebook;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
