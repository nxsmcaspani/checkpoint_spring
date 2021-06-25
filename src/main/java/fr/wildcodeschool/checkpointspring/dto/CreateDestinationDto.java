package fr.wildcodeschool.checkpointSpring.dto;


import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CreateDestinationDto {
    private Integer id;
    private String country;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public CreateDestinationDto() {
    }

    public CreateDestinationDto(String country, LocalDate startDate, LocalDate endDate) {
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
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

}
