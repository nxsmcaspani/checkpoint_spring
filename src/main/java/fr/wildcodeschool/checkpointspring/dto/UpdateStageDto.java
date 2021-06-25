package fr.wildcodeschool.checkpointSpring.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class UpdateStageDto {
    private Integer id;
    private Integer destinationId;
    private String city;
    private String summary;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate stageDate;
    private List<UpdateResourceDto> updateResourceDtoList;

    public UpdateStageDto() {
    }

    public UpdateStageDto(Integer id, String city, String summary, List<UpdateResourceDto> updateResourceDtoList) {
        this.id = id;
        this.city = city;
        this.summary = summary;
        this.updateResourceDtoList = updateResourceDtoList;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinatioId) {
        this.destinationId = destinationId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDate getStageDate() {
        return stageDate;
    }

    public void setStageDate(LocalDate stageDate) {
        this.stageDate = stageDate;
    }

    public List<UpdateResourceDto> getUpdateResourceDtoList() {
        return updateResourceDtoList;
    }

    public void setUpdateResourceDtoList(List<UpdateResourceDto> updateResourceDtoList) {
        this.updateResourceDtoList = updateResourceDtoList;
    }
}
