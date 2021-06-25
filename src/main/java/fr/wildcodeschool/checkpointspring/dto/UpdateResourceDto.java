package fr.wildcodeschool.checkpointSpring.dto;

public class UpdateResourceDto {
    private Integer id;
    private Integer idStage;
    private String resource;

    public UpdateResourceDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdStage() {
        return idStage;
    }

    public void setIdStage(Integer idStage) {
        this.idStage = idStage;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
