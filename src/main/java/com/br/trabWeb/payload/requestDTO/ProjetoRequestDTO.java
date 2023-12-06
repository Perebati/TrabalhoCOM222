package com.br.trabWeb.payload.requestDTO;

import java.time.LocalDateTime;
import java.util.List;

public class ProjetoRequestDTO {
    private String titulo;

    private String descricao;

    private String fotoUrl;

    private List<String> autores;

    private LocalDateTime data;

    private String linkRepositorio;

    public ProjetoRequestDTO() {
    }

    public ProjetoRequestDTO(String titulo, String descricao, String fotoUrl, List<String> autores, LocalDateTime data, String linkRepositorio) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.fotoUrl = fotoUrl;
        this.autores = autores;
        this.data = data;
        this.linkRepositorio = linkRepositorio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getLinkRepositorio() {
        return linkRepositorio;
    }

    public void setLinkRepositorio(String linkRepositorio) {
        this.linkRepositorio = linkRepositorio;
    }
}
