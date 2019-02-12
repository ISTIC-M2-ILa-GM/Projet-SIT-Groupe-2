package fr.univ_rennes1.istic.sit.groupe2.back_sit.dao;


import fr.univ_rennes1.istic.sit.groupe2.back_sit.models.Drone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DroneDao extends MongoRepository<Drone,Long> {

}
