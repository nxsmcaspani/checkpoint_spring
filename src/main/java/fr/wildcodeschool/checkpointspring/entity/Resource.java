package fr.wildcodeschool.checkpointSpring.entity;

import javax.persistence.*;

@Entity
@Table(name="resource")
public class Resource {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String resource;

    @ManyToOne
    @JoinColumn(name="stage_id", columnDefinition="int")
    private Stage stage;

    public Resource() {
    }

    public Resource(String resource, Stage stage) {
        this.resource = resource;
        this.stage = stage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
