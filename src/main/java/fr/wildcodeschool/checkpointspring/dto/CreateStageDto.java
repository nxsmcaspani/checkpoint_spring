package fr.wildcodeschool.checkpointSpring.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class CreateStageDto {
    private String city;
    private String summary;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate stageDate;
    private Integer destinationId;
    private UpdateDestinationDto updateDestinationDto;

    public CreateStageDto() {
    }

    public CreateStageDto(Integer id, String city, String summary, List<UpdateResourceDto> updateResourceDtoList) {
        this.city = city;
        this.summary = summary;
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

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public UpdateDestinationDto getUpdateDestinationDto() {
        return updateDestinationDto;
    }

    public void setUpdateDestinationDto(UpdateDestinationDto updateDestinationDto) {
        this.updateDestinationDto = updateDestinationDto;
    }
}
