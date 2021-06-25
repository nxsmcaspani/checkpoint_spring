package fr.wildcodeschool.checkpointSpring.repository;

import fr.wildcodeschool.checkpointSpring.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Integer> {
}
