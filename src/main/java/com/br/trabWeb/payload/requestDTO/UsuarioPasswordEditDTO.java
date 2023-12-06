package com.br.trabWeb.payload.requestDTO;

public class UsuarioPasswordEditDTO {
    private String password;

    public UsuarioPasswordEditDTO() {
    }

    public UsuarioPasswordEditDTO(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
