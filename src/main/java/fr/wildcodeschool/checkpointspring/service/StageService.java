package fr.wildcodeschool.checkpointSpring.service;

import fr.wildcodeschool.checkpointSpring.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class StageService {
    @Autowired
    private StageRepository stageRepository;

}
