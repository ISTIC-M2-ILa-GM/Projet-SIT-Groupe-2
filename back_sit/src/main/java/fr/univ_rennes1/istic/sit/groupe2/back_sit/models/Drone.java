package fr.univ_rennes1.istic.sit.groupe2.back_sit.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter
public class Drone {

    @Id
    private String id;

    public Drone() {

    }

    public Drone(String id) {

        this.id = id;
    }

}
