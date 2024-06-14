package com.hakkinenT.cinema_ticket_sales.models.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Session {
    private String id;
    private LocalDateTime date;
    private Double fullTicketValue;
    private Double halfTicketValue;
    private boolean closed;

    @DBRef
    private Movie movie;

    @DBRef
    private ScreeningRoom room;

    public Session() {
    }

    public Session(String id, LocalDateTime date, Double fullTicketValue, Double halfTicketValue, boolean closed) {
        this.id = id;
        this.date = date;
        this.fullTicketValue = fullTicketValue;
        this.halfTicketValue = halfTicketValue;
        this.closed = closed;
    }

    public Session(String id, LocalDateTime date, Double fullTicketValue, Double halfTicketValue, boolean closed, Movie movie, ScreeningRoom room) {
        this.id = id;
        this.date = date;
        this.fullTicketValue = fullTicketValue;
        this.halfTicketValue = halfTicketValue;
        this.closed = closed;
        this.movie = movie;
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getFullTicketValue() {
        return fullTicketValue;
    }

    public void setFullTicketValue(Double fullTicketValue) {
        this.fullTicketValue = fullTicketValue;
    }

    public Double getHalfTicketValue() {
        return halfTicketValue;
    }

    public void setHalfTicketValue(Double halfTicketValue) {
        this.halfTicketValue = halfTicketValue;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public ScreeningRoom getRoom() {
        return room;
    }

    public void setRoom(ScreeningRoom room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
