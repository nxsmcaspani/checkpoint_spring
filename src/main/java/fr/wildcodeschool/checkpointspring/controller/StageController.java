package fr.wildcodeschool.checkpointSpring.controller;

import fr.wildcodeschool.checkpointSpring.dto.CreateStageDto;
import fr.wildcodeschool.checkpointSpring.dto.UpdateStageDto;
import fr.wildcodeschool.checkpointSpring.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StageController {
    @Autowired
    private StageService stageService;

    @GetMapping("/stage/{id}")
    public String getStageDetails(Model model, @PathVariable(name = "id") Integer idPlage){
        return "stage";
    }

    @GetMapping("/createstage/{id}")
    public String getStageCreationForm(Model model, @PathVariable(name = "id") Integer idDest){
        return "createstage";
    }

    @PostMapping("/addstage")
    public String addStage(Model model, CreateStageDto createStageDto){
        return "redirect:/";
    }

    @PostMapping("/updatestage")
    public String updateStage(Model model, UpdateStageDto updateStageDto){
        return "redirect:/stage";
    }

    @GetMapping("/deletestage/{id}")
    public String deleteStage(Model model, Integer idStage){
        return "redirect:/";
    }

}
