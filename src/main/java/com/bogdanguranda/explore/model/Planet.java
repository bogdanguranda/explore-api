package com.bogdanguranda.explore.model;

import java.sql.Blob;
import java.util.List;

public class Planet {

    private int id;
    private String name;
    private Blob image;
    private String description;
    private Status status;
    private List<String> robots;

    public Planet() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<String> getRobots() {
        return robots;
    }

    public void setRobots(List<String> robots) {
        this.robots = robots;
    }
}
