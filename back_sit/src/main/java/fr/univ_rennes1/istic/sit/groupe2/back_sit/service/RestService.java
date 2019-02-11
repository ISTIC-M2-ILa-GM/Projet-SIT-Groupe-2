package fr.univ_rennes1.istic.sit.groupe2.back_sit.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestService {

    @RequestMapping("/missions")
    public ResponseEntity<?> getmissions(){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
