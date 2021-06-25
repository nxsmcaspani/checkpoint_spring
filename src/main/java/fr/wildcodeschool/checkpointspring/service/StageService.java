package fr.wildcodeschool.checkpointSpring.service;

import fr.wildcodeschool.checkpointSpring.dto.CreateStageDto;
import fr.wildcodeschool.checkpointSpring.dto.UpdateResourceDto;
import fr.wildcodeschool.checkpointSpring.dto.UpdateStageDto;
import fr.wildcodeschool.checkpointSpring.entity.Resource;
import fr.wildcodeschool.checkpointSpring.entity.Stage;
import fr.wildcodeschool.checkpointSpring.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StageService {
    @Autowired
    private StageRepository stageRepository;

    @Autowired
    private DestinationService destinationService;

    @Autowired
    private ResourceService resourceService;

    public List<Stage> findAll() { return stageRepository.findAll(); }

    public Stage addStage(CreateStageDto createStageDto){
        return stageRepository.save(convertFromDtoToEntityForCreation(createStageDto));
    }

    public Stage updateStage(UpdateStageDto updateStageDto){
        return stageRepository.save(convertFromDtoToEntityForUpdate(updateStageDto));
    }


    public void deleteStage(Integer idStage){
        Optional<Stage> optionalStage = stageRepository.findById(idStage);
        if(optionalStage.isPresent()){
            Stage stage = optionalStage.get();
            stageRepository.delete(stage);
        } else throw new RuntimeException();
    }

    public Stage convertFromDtoToEntityForCreation(CreateStageDto createStageDto){
        Stage stage = new Stage();
        stage.setCity(createStageDto.getCity());
        stage.setSummary(createStageDto.getSummary());
        stage.setStageDate(createStageDto.getStageDate());
        stage.setDestination(destinationService.findById(createStageDto.getDestinationId()));
        return stage;
    }

    public UpdateStageDto convertFromEntityToDtoForUpdate(Integer idStage){
        Optional<Stage> optionalStage = stageRepository.findById(idStage);
        if(optionalStage.isPresent()) {
            Stage stage = optionalStage.get();;
            UpdateStageDto updateStageDto = new UpdateStageDto();
            updateStageDto.setId(stage.getId());
            updateStageDto.setCity(stage.getCity());
            updateStageDto.setStageDate(stage.getStageDate());
            updateStageDto.setSummary(stage.getSummary());
            updateStageDto.setDestinationId(stage.getDestination().getId());
            List<UpdateResourceDto> updateResourceDtoList = new ArrayList<>();
            for (Resource resource : stage.getResourceList()) {
                updateResourceDtoList.add(resourceService.convertFromEntityToDtoForUpdate(resource.getId()));
            }
            updateStageDto.setUpdateResourceDtoList(updateResourceDtoList);
            return updateStageDto;
        } else throw new RuntimeException();
    }

    public UpdateStageDto convertFromEntityToDtoForRead(Integer idStage){
        Optional<Stage> optionalStage = stageRepository.findById(idStage);
        if(optionalStage.isPresent()) {
            Stage stage = optionalStage.get();
            UpdateStageDto updateStageDto = new UpdateStageDto();
            updateStageDto.setId(stage.getId());
            updateStageDto.setCity(stage.getCity());
            updateStageDto.setStageDate(stage.getStageDate());
            updateStageDto.setSummary(stage.getSummary());
            return updateStageDto;
        } else throw new RuntimeException();
    }

    private Stage convertFromDtoToEntityForUpdate(UpdateStageDto updateStageDto) {
        Optional<Stage> optionalStage = stageRepository.findById(updateStageDto.getId());
        if(optionalStage.isPresent()) {
            Stage stage = optionalStage.get();
            stage.setId(updateStageDto.getId());
            stage.setStageDate(updateStageDto.getStageDate());
            stage.setCity(updateStageDto.getCity());
            stage.setSummary(updateStageDto.getSummary());
            return stage;
        } else throw new RuntimeException();

    }

}
