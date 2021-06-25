package fr.wildcodeschool.checkpointSpring.repository;

import fr.wildcodeschool.checkpointSpring.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository extends JpaRepository<Stage, Integer> {
}
