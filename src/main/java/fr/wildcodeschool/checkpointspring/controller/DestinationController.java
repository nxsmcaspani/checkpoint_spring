package fr.wildcodeschool.checkpointSpring.controller;

import fr.wildcodeschool.checkpointSpring.dto.CreateDestinationDto;
import fr.wildcodeschool.checkpointSpring.dto.UpdateDestinationDto;
import fr.wildcodeschool.checkpointSpring.entity.Destination;
import fr.wildcodeschool.checkpointSpring.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping("/")
    public String welcome(Model model){
        List<UpdateDestinationDto> updateDestinationDtoList = new ArrayList<>();
        for(Destination destination : destinationService.findAll()){
            updateDestinationDtoList.add(destinationService.convertFromEntityToDtoForRead(destination.getId()));
        }
        model.addAttribute("destinations", updateDestinationDtoList);
        return "index";
    }

    @GetMapping("/dest/{id}")
    public String getDestinationDetails(Model model, @PathVariable(name = "id") Integer idDest){
        UpdateDestinationDto updateDestinationDto = destinationService.convertFromEntityToDtoForRead(idDest);
        model.addAttribute("destination", updateDestinationDto);
        return "destination";
    }

    @GetMapping("/createdest")
    public String getDestinationCreationForm(Model model){
        CreateDestinationDto createDestinationDto = new CreateDestinationDto();
        model.addAttribute("createdestination", createDestinationDto);
        return "createdest";
    }

    @PostMapping("/adddest")
    public String addDestination(Model model, CreateDestinationDto createDestinationDto){
        destinationService.addDestination(createDestinationDto);
        return "redirect:/";
    }

    @GetMapping("/updatedest/{id}")
    public String updateDestination(Model model, @PathVariable(name = "id") Integer idDest){
        UpdateDestinationDto updateDestinationDto = destinationService.convertFromEntityToDtoForRead(idDest);
        model.addAttribute("destination", updateDestinationDto);
        return "updatedestination";
    }

    @PostMapping("/updatedest")
    public String updateDestination(UpdateDestinationDto updateDestinationDto){
        destinationService.updateDestination(updateDestinationDto);
        return "redirect:/";
    }

    @GetMapping("/deletedest/{id}")
    public String deleteDestination(Model model, @PathVariable(name = "id") Integer idDest){
        destinationService.deleteDestination(idDest);
        return "redirect:/";
    }
}
