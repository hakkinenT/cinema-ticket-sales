package com.hakkinenT.cinema_ticket_sales.models.dto;

import com.hakkinenT.cinema_ticket_sales.models.embedded.Actor;
import com.hakkinenT.cinema_ticket_sales.models.entities.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDTO {
    private String id;
    private String title;
    private String duration;
    private List<Actor> actors = new ArrayList<>();

    private GenderDTO gender;

    public MovieDTO() {
    }

    public MovieDTO(String id, String title, String duration, GenderDTO gender) {
        this.id = id.toLowerCase().replaceAll("\\s","");
        this.title = title;
        this.duration = duration;
        this.gender = gender;
    }

    public MovieDTO(Movie entity) {
        this.id = entity.getId().toLowerCase().replaceAll("\\s","");
        this.title = entity.getTitle();
        this.duration = entity.getDuration();
        entity.getActors().forEach(actor -> this.getActors().add(actor));
        this.gender = entity.getGender() != null ? new GenderDTO(entity.getGender()) : null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.toLowerCase().replaceAll("\\s","");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public GenderDTO getGender() {
        return gender;
    }

    public void setGender(GenderDTO gender) {
        this.gender = gender;
    }
}
