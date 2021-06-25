package fr.wildcodeschool.checkpointSpring.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class UpdateDestinationDto {
    private Integer id;
    private String country;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private List<UpdateStageDto> updateStageDtoList;

    public UpdateDestinationDto() {
    }

    public UpdateDestinationDto(String country, LocalDate startDate, LocalDate endDate) {
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

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

    public List<UpdateStageDto> getUpdateStageDtoList() {
        return updateStageDtoList;
    }

    public void setUpdateStageDtoList(List<UpdateStageDto> updateStageDtoList) {
        this.updateStageDtoList = updateStageDtoList;
    }
}
