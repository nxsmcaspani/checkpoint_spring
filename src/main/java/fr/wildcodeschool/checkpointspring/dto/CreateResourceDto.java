package fr.wildcodeschool.checkpointSpring.dto;

public class CreateResourceDto {
    private int id;
    private int idStage;
    private String resource;

    public CreateResourceDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStage() {
        return idStage;
    }

    public void setIdStage(int idStage) {
        this.idStage = idStage;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
