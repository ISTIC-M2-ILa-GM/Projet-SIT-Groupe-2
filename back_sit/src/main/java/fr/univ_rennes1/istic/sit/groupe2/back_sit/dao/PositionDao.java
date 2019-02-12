package fr.univ_rennes1.istic.sit.groupe2.back_sit.dao;

import fr.univ_rennes1.istic.sit.groupe2.back_sit.models.Position;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PositionDao extends MongoRepository<Position,Long> {
}
