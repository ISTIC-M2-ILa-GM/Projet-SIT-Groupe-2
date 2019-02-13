package fr.univ_rennes1.istic.sit.groupe2.back_sit.controllers;

import fr.univ_rennes1.istic.sit.groupe2.back_sit.dao.MissionDao;
import fr.univ_rennes1.istic.sit.groupe2.back_sit.dao.PositionDao;
import fr.univ_rennes1.istic.sit.groupe2.back_sit.models.Mission;
import fr.univ_rennes1.istic.sit.groupe2.back_sit.models.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api")
public class RestService {

    @Autowired
    private MissionDao missionDao;
    @Autowired
    private PositionDao positionDao;

    @RequestMapping("/missions")
    public ResponseEntity<?> getMissions() {
        return new ResponseEntity<>(missionDao.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/missions/{id}/start", method = RequestMethod.PATCH)
    public ResponseEntity<?> startMission(@PathVariable(value = "id") String id) {

        Mission mission = missionDao.findById(id)
                .orElseThrow(() -> new RuntimeException("mission not found"));
        mission.setStartDate(Instant.now());
        missionDao.save(mission);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping("/positions")
    public ResponseEntity<?> getPositions() {
        return new ResponseEntity<>(positionDao.findAll(), HttpStatus.OK);
    }

    //FOR TESTING!!!!
    @RequestMapping("/test")
    public ResponseEntity<?> test() {
        Position pos = new Position("id" + Instant.now(), 0, 0);
        positionDao.save(pos);
        return new ResponseEntity<>(positionDao.findAll(), HttpStatus.OK);
    }
}
