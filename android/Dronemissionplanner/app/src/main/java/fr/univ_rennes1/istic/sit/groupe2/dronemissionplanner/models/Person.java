package fr.univ_rennes1.istic.sit.groupe2.dronemissionplanner.models;

import com.google.gson.annotations.SerializedName;

public class Person {
    @SerializedName("name")
    private String name;

    @SerializedName("height")
    private String height;

    public Person(String name, String height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
