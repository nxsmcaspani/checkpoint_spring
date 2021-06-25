package fr.wildcodeschool.checkpointSpring.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "destination")
public class Destination {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String country;
    private LocalDate startDate;
    private LocalDate endDate ;

    @OneToMany (mappedBy="destination")
    @Column(columnDefinition="int")
    private List<Stage> stageList;

    public Destination() {
    }

    public Destination(String country, LocalDate startDate, LocalDate endDate) {
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Stage> getStageList() {
        return stageList;
    }

    public void setStageList(List<Stage> stageList) {
        this.stageList = stageList;
    }
}
