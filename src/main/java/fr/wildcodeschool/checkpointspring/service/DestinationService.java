package fr.wildcodeschool.checkpointSpring.service;

import fr.wildcodeschool.checkpointSpring.dto.CreateDestinationDto;
import fr.wildcodeschool.checkpointSpring.dto.UpdateDestinationDto;
import fr.wildcodeschool.checkpointSpring.dto.UpdateStageDto;
import fr.wildcodeschool.checkpointSpring.entity.Destination;
import fr.wildcodeschool.checkpointSpring.entity.Stage;
import fr.wildcodeschool.checkpointSpring.repository.DestinationRepository;
import fr.wildcodeschool.checkpointSpring.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {
    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private StageRepository stageRepository;

    public List<Destination> findAll() { return destinationRepository.findAll(); }

    public Destination addDestination(CreateDestinationDto createDestinationDto){
        return destinationRepository.save(convertFromDtoToEntityForCreation((createDestinationDto)));
    }

    public Destination updateDestination(UpdateDestinationDto updateDestinationDto){
        return destinationRepository.save(convertFromDtoToEntityForUpdate(updateDestinationDto));
    }

    public void deleteDestination(Integer idDestination){
        Optional<Destination> optionalDestination = destinationRepository.findById(idDestination);
        if(optionalDestination.isPresent()){
            Destination destination = optionalDestination.get();
            destinationRepository.delete(destination);
        } else throw new RuntimeException();
    }

    public Destination convertFromDtoToEntityForCreation(CreateDestinationDto createDestinationDto){
        Destination destination = new Destination();
        destination.setCountry(createDestinationDto.getCountry());
        destination.setStartDate(createDestinationDto.getStartDate());
        destination.setEndDate(createDestinationDto.getEndDate());
        return destination;
    }

    public Destination convertFromDtoToEntityForUpdate(UpdateDestinationDto updateDestinationDto){
        Optional<Destination> optionalDestination = destinationRepository.findById(updateDestinationDto.getId());
        if(optionalDestination.isPresent()) {
            Destination destination = optionalDestination.get();
            destination.setId(updateDestinationDto.getId());
            destination.setCountry(updateDestinationDto.getCountry());
            destination.setStartDate(updateDestinationDto.getStartDate());
            destination.setEndDate(updateDestinationDto.getEndDate());
            List<Stage> stageList = new ArrayList<>();
            for(UpdateStageDto updateStageDto : updateDestinationDto.getUpdateStageDtoList()){
                Optional<Stage> optionalStage = stageRepository.findById(updateStageDto.getId());
                Stage stage = optionalStage.orElseThrow(RuntimeException::new);
                stageList.add(stage);
            }
            destination.setStageList(stageList);
            return destination;
        } else throw new RuntimeException();
    }

    public UpdateDestinationDto convertFromEntityToDtoForRead(Integer idDest){
        Optional<Destination> optionalDestination = destinationRepository.findById(idDest);
        if(optionalDestination.isPresent()) {
            Destination destination = optionalDestination.get();;
            UpdateDestinationDto destinationDto = new UpdateDestinationDto();
            destinationDto.setId(destination.getId());
            destinationDto.setCountry(destination.getCountry());
            destinationDto.setStartDate(destination.getStartDate());
            destinationDto.setEndDate(destination.getEndDate());
            return destinationDto;
        } else throw new RuntimeException();
    }
}
