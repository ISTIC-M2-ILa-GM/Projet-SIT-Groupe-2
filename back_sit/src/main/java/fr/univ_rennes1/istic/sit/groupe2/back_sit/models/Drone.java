package fr.univ_rennes1.istic.sit.groupe2.back_sit.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Drone {

    private String id;

    public Drone() {

    }

    public Drone(String id) {
        this.id = id;
    }

}
