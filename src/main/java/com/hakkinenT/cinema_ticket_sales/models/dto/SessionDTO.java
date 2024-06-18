package com.hakkinenT.cinema_ticket_sales.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hakkinenT.cinema_ticket_sales.models.entities.Session;

import java.time.LocalDateTime;

public class SessionDTO {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime date;
    private Integer roomNumber;
    private String movieId;
    private Double fullTicketValue;
    private Double halfTicketValue;
    private boolean closed;

    public SessionDTO() {
    }

    public SessionDTO(LocalDateTime date, Integer roomNumber, String movieId, Double fullTicketValue, Double halfTicketValue, boolean closed) {
        this.date = date;
        this.roomNumber = roomNumber;
        this.movieId = movieId;
        this.fullTicketValue = fullTicketValue;
        this.halfTicketValue = halfTicketValue;
        this.closed = closed;
    }

    public SessionDTO(Session entity) {
        date = entity.getId().getDate();
        roomNumber = entity.getId().getRoomNumber();
        movieId = entity.getId().getMovieId();
        fullTicketValue = entity.getFullTicketValue();
        halfTicketValue = entity.getHalfTicketValue();
        closed = entity.isClosed();
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

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
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
}
