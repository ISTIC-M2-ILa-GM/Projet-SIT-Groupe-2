package fr.univ_rennes1.istic.sit.groupe2.back_sit.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class mission {

    private long id;
    private String name;

    private List<Position> route;

    public mission() {

    }
    public mission(long id, String name, List<Position> route) {
        this.id = id;
        this.name = name;
        this.route = route;
    }
}
