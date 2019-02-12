package fr.univ_rennes1.istic.sit.groupe2.back_sit.controllers;

import fr.univ_rennes1.istic.sit.groupe2.back_sit.dao.MissionDao;
import fr.univ_rennes1.istic.sit.groupe2.back_sit.dao.PositionDao;
import fr.univ_rennes1.istic.sit.groupe2.back_sit.models.Mission;
import fr.univ_rennes1.istic.sit.groupe2.back_sit.models.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestService {

    @Autowired
    private MissionDao missionDao;

    @Autowired
    private PositionDao positionDao;

    @RequestMapping("/missions")
    public ResponseEntity<?> getMissions() {
        List<Mission> missions = missionDao.findAll();
        return new ResponseEntity<>(missions, HttpStatus.OK);
    }

    @RequestMapping("/positions")
    public ResponseEntity<?> getPositions() {
        List<Position> positions = positionDao.findAll();
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }
}
