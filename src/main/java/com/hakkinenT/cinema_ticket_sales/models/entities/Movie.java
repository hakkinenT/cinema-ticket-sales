package com.hakkinenT.cinema_ticket_sales.models.entities;

import com.hakkinenT.cinema_ticket_sales.models.embedded.Actor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "movies")
public class Movie {
    @Id
    private String id;
    private String title;
    private String duration;
    private List<Actor> actors = new ArrayList<>();

    @DBRef
    private Gender gender;

    public Movie() {
    }

    public Movie(String id, String title, String duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Movie(String id, String title, String duration, Gender gender) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
