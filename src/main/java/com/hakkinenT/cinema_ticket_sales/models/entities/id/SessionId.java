package com.hakkinenT.cinema_ticket_sales.models.entities.id;

import java.time.LocalDateTime;
import java.util.Objects;

public class SessionId {
    private LocalDateTime date;
    private Integer roomNumber;
    private String movieId;

    public SessionId() {
    }

    public SessionId(LocalDateTime date, Integer roomNumber, String movieId) {
        this.date = date;
        this.roomNumber = roomNumber;
        this.movieId = movieId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomId(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionId sessionId = (SessionId) o;
        return Objects.equals(date, sessionId.date) && Objects.equals(roomNumber, sessionId.roomNumber) && Objects.equals(movieId, sessionId.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, roomNumber, movieId);
    }
}
