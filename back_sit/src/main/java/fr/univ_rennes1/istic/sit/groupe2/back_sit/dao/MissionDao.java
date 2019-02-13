package fr.univ_rennes1.istic.sit.groupe2.back_sit.dao;



import fr.univ_rennes1.istic.sit.groupe2.back_sit.models.Mission;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.Instant;

public interface MissionDao extends MongoRepository<Mission,String> {

    public Mission findByName(String name);

    public Mission findByStartDateAndAndEndDate(Instant startDate, Instant endDate);


}
