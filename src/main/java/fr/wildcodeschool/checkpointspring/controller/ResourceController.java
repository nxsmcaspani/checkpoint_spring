package fr.wildcodeschool.checkpointSpring.controller;

import fr.wildcodeschool.checkpointSpring.dto.CreateResourceDto;
import fr.wildcodeschool.checkpointSpring.dto.UpdateResourceDto;
import fr.wildcodeschool.checkpointSpring.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @GetMapping("/resource/{id}")
    public String getResourceDetails(Model model, @PathVariable(name = "id") Integer idResource){
        return "stage";
    }

    @GetMapping("/createresource/{id}")
    public String getResourceCreationForm(Model model, @PathVariable(name = "id") Integer idStage){
        return "createresource";
    }

    @PostMapping("/addresource")
    public String addResource(Model model, CreateResourceDto createResourceDto){
        return "redirect:/";
    }

    @PostMapping("/updateresource")
    public String updateResource(Model model, UpdateResourceDto updateResourceDto){
        return "redirect:/stage";
    }

    @GetMapping("/deleteresource/{id}")
    public String deleteResource(Model model, Integer idResource){
        return "redirect:/";
    }
}
