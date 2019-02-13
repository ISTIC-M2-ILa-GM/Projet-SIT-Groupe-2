package fr.univ_rennes1.istic.sit.groupe2.back_sit.models;

import jdk.internal.jline.internal.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class Mission {

    private String id;

    private List<Position> route;

    @Nullable
    private Instant startDate;

    @Nullable
    private Instant endDate;


    public Mission() {
    }

    public Mission(String id, List<Position> route) {
        this.id = id;
        this.route = route;
    }

    public Mission(String id, List<Position> route, Instant startDate, Instant endDate) {
        this.id = id;
        this.route = route;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
