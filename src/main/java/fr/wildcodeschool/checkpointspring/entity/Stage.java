package fr.wildcodeschool.checkpointSpring.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "stage")
public class Stage {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String city;
    private LocalDate stageDate;
    private @Column(length = 2048) String summary;

    @ManyToOne
    @JoinColumn(name="destination_id", columnDefinition="int")
    private Destination destination;

    @OneToMany (mappedBy="stage", cascade = CascadeType.REMOVE)
    @Column(columnDefinition="int")
    private List<Resource> resourceList;

    public Stage() {
    }

    public Stage(String city, LocalDate stageDate, String summary, Destination destination) {
        this.city = city;
        this.stageDate = stageDate;
        this.summary = summary;
        this.destination = destination;
    }

    public Stage(String city, LocalDate stageDate, String summary) {
        this.city = city;
        this.stageDate = stageDate;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getStageDate() {
        return stageDate;
    }

    public void setStageDate(LocalDate stageDate) {
        this.stageDate = stageDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }
}
