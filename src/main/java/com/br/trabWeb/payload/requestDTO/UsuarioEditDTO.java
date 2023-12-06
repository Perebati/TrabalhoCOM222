package com.br.trabWeb.payload.requestDTO;

import jakarta.validation.constraints.Size;

public class UsuarioEditDTO {
    @Size(max = 512)
    private String bio;

    @Size(max = 64)
    private String github;

    @Size(max = 64)
    private String linkedin;

    @Size(max = 64)
    private String instagram;

    @Size(max = 64)
    private String facebook;

    @Size(max = 64)
    private String fotoUrl;

    public UsuarioEditDTO() {
    }

    public UsuarioEditDTO(String bio, String github, String linkedin, String instagram, String facebook, String fotoUrl) {
        this.bio = bio;
        this.github = github;
        this.linkedin = linkedin;
        this.instagram = instagram;
        this.facebook = facebook;
        this.fotoUrl = fotoUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }
}
