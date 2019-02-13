package fr.univ_rennes1.istic.sit.groupe2.back_sit.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter@Setter
public class Position {

    @Id
    private String id;
    private float lat;
    private float lon;


    public Position() {

    }

    public Position(String id, float lat, float lon) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
    }
}
