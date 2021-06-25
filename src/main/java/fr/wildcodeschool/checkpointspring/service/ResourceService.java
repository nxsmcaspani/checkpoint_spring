package fr.wildcodeschool.checkpointSpring.service;

import fr.wildcodeschool.checkpointSpring.dto.UpdateResourceDto;
import fr.wildcodeschool.checkpointSpring.dto.UpdateStageDto;
import fr.wildcodeschool.checkpointSpring.entity.Resource;
import fr.wildcodeschool.checkpointSpring.entity.Stage;
import fr.wildcodeschool.checkpointSpring.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public UpdateResourceDto convertFromEntityToDtoForUpdate(Integer idResource){
        Optional<Resource> optionalResource = resourceRepository.findById(idResource);
        if(optionalResource.isPresent()) {
            Resource resource = optionalResource.get();;
            UpdateResourceDto updateResourceDto = new UpdateResourceDto();
            updateResourceDto.setId(resource.getId());
            updateResourceDto.setIdStage(resource.getStage().getId());
            updateResourceDto.setResource(resource.getResource());
            return updateResourceDto;
        } else throw new RuntimeException();
    }
}
