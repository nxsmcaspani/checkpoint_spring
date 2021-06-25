package fr.wildcodeschool.checkpointSpring.dto;

import java.util.List;

public class CreateStageDto {
    private String city;
    private String summary;

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
}
