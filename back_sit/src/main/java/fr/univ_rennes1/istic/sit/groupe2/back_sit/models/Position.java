package fr.univ_rennes1.istic.sit.groupe2.back_sit.models;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Position {

    private long id;
    private float lat;
    private float lon;


    public Position() {

    }

    public Position(long id, float lat, float lon) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
    }
}
