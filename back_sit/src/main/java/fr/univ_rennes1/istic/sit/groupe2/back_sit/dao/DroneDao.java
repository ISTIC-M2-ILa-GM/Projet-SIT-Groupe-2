package fr.univ_rennes1.istic.sit.groupe2.back_sit.dao;

import fr.univ_rennes1.istic.sit.groupe2.back_sit.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneDao extends JpaRepository<Drone,Long> {

}
