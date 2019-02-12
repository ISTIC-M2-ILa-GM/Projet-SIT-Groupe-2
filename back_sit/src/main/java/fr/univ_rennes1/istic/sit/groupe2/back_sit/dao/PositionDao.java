package fr.univ_rennes1.istic.sit.groupe2.back_sit.dao;

import fr.univ_rennes1.istic.sit.groupe2.back_sit.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<Position,Long> {
}
