package fr.wildcodeschool.checkpointSpring.service;

import fr.wildcodeschool.checkpointSpring.dto.CreateResourceDto;
import fr.wildcodeschool.checkpointSpring.dto.UpdateResourceDto;
import fr.wildcodeschool.checkpointSpring.entity.Resource;
import fr.wildcodeschool.checkpointSpring.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private StageService stageService;

    public Resource addResource(CreateResourceDto createResourceDto){
        return resourceRepository.save(convertFromDtoToEntityForCreation(createResourceDto));
    }

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

    public CreateResourceDto getCreateResourceDto(Integer idStage){
        CreateResourceDto createResourceDto = new CreateResourceDto();
        createResourceDto.setIdStage(idStage);
        return createResourceDto;
    }

    public Integer getStageIdFromResourceId(Integer idResource) {
        Optional<Resource> optionalResource = resourceRepository.findById(idResource);
        if(optionalResource.isPresent()){
            Resource resource = optionalResource.get();
            return resource.getStage().getId();
        } else throw new RuntimeException();
    }

    public void updateResource(UpdateResourceDto updateResourceDto) {
        resourceRepository.save(convertFromDtoToEntityForUpdate(updateResourceDto));
    }

    public void deleteResource(Integer idResource) {
        Optional<Resource> optionalResource = resourceRepository.findById(idResource);
        if(optionalResource.isPresent()){
            Resource resource = optionalResource.get();
            resourceRepository.delete(resource);
        } else throw new RuntimeException();
    }

    private Resource convertFromDtoToEntityForCreation(CreateResourceDto createResourceDto){
        Resource resource = new Resource();
        resource.setStage(stageService.getById(createResourceDto.getIdStage()));
        resource.setResource(createResourceDto.getResource());
        return resource;
    }

    private Resource convertFromDtoToEntityForUpdate(UpdateResourceDto updateResourceDto){
        Resource resource = new Resource();
        resource.setStage(stageService.getById(updateResourceDto.getIdStage()));
        resource.setResource(updateResourceDto.getResource());
        resource.setId(updateResourceDto.getId());
        return resource;
    }
}
