package fr.univ_rennes1.istic.sit.groupe2.back_sit.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Drone {

    private long id;

    public Drone() {

    }

    public Drone(long id) {
        this.id = id;
    }

}
