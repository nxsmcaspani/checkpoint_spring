package fr.wildcodeschool.checkpointSpring.dto;

import java.util.List;

public class UpdateStageDto {
    private Integer id;
    private String city;
    private String summary;
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

    public List<UpdateResourceDto> getUpdateResourceDtoList() {
        return updateResourceDtoList;
    }

    public void setUpdateResourceDtoList(List<UpdateResourceDto> updateResourceDtoList) {
        this.updateResourceDtoList = updateResourceDtoList;
    }
}
