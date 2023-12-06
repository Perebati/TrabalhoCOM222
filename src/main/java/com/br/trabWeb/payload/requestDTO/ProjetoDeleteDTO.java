package com.br.trabWeb.payload.requestDTO;

public class ProjetoDeleteDTO {
    private Long projectId;

    public ProjetoDeleteDTO(Long projectId) {
        this.projectId = projectId;
    }

    public ProjetoDeleteDTO() {
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
