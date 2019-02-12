package fr.univ_rennes1.istic.sit.groupe2.back_sit.model;

import java.util.List;

public class Mission {

    private long id;

    private List<Position> route;

    public Mission() {
    }

    public Mission(long id, List<Position> route) {
        this.id = id;
        this.route = route;
    }
}
