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
        model.addAttribute("updateresourcedto", resourceService.convertFromEntityToDtoForUpdate(idResource));
        return "updateresource";
    }

    @PostMapping("/addresource")
    public String addResource(CreateResourceDto createResourceDto){
        resourceService.addResource(createResourceDto);
        return "redirect:/stage/"+createResourceDto.getIdStage();
    }

    @PostMapping("/updateresource")
    public String updateResource(UpdateResourceDto updateResourceDto){
        resourceService.updateResource(updateResourceDto);
        return "redirect:/stage/"+updateResourceDto.getIdStage();
    }

    @GetMapping("/deleteresource/{id}")
    public String deleteResource(@PathVariable(name = "id") Integer idResource){
        if(idResource != null) {
            Integer idStage = resourceService.getStageIdFromResourceId(idResource);
            resourceService.deleteResource(idResource);
            return "forward:/stage/" + idStage;
        } else throw new RuntimeException();
    }
}
