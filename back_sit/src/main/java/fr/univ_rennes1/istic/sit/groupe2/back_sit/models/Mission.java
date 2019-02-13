package fr.univ_rennes1.istic.sit.groupe2.back_sit.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class Mission {

    private String id;

    private String name;

    private List<Position> route;

    @Nullable
    private Instant startDate;

    @Nullable
    private Instant endDate;


    public Mission() {
    }

    public Mission(String id, List<Position> route,String name) {
        this.id = id;
        this.route = route;
        this.name = name;
    }

    public Mission(String id,String name, List<Position> route, Instant startDate, Instant endDate) {
        this.id = id;
        this.id = id;
        this.route = route;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
