package fr.univ_rennes1.istic.sit.groupe2.back_sit.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Image {

    @Id
    private String id;

    private String name;

    private byte[] body;

    public Image(String id, String name, byte[] body) {
        this.id = id;
        this.name = name;
        this.body = body;
    }

    public Image() {
    }
}
