package fr.univ_rennes1.istic.sit.groupe2.back_sit.controllers;

import fr.univ_rennes1.istic.sit.groupe2.back_sit.dao.MissionDao;
import fr.univ_rennes1.istic.sit.groupe2.back_sit.dao.PositionDao;
import fr.univ_rennes1.istic.sit.groupe2.back_sit.models.Mission;
import fr.univ_rennes1.istic.sit.groupe2.back_sit.models.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/missions")
public class RestService {

    @Autowired
    private MissionDao missionDao;
    @Autowired
    private PositionDao positionDao;

    @RequestMapping("")
    public ResponseEntity<?> getMissions() {
        return new ResponseEntity<>(missionDao.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createMissions(@RequestBody Mission mission) {
        mission = missionDao.save(mission);
        return new ResponseEntity<>(mission, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/start", method = RequestMethod.PATCH)
    public ResponseEntity<?> startMission(@PathVariable(value = "id") String id) {

        Mission mission = missionDao.findById(id)
                .orElseThrow(() -> new RuntimeException("mission not found"));
        mission.setStartDate(Instant.now());
        missionDao.save(mission);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/stop", method = RequestMethod.PATCH)
    public ResponseEntity<?> stopMission(@PathVariable(value = "id") String id) {

        Mission mission = missionDao.findById(id)
                .orElseThrow(() -> new RuntimeException("mission not found"));
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping("/{id}/positions")
    public ResponseEntity<?> getPositions(@PathVariable(value = "id") String id) {
        Mission mission = missionDao.findById(id)
                .orElseThrow(() -> new RuntimeException("mission not found"));
        return new ResponseEntity<>(mission.getRoute(), HttpStatus.OK);
    }

    //FOR TESTING!!!!
    @RequestMapping("/test")
    public ResponseEntity<?> test() {
        Position pos = new Position("id" + Instant.now(), 0, 0);
        positionDao.save(pos);
        List<Position> positions = new ArrayList<>();
        positions.add(pos);
        Mission mission = new Mission("id" + Instant.now(), positions, "missionName");
        missionDao.save(mission);
        return new ResponseEntity<>(positionDao.findAll(), HttpStatus.OK);
    }
}
