package com.hakkinenT.cinema_ticket_sales.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "seats")
public class Seat {
    @Id
    private String id;
    private String code;

    @DBRef
    private ScreeningRoom room;

    public Seat() {
    }

    public Seat(String id, String code, ScreeningRoom room) {
        this.id = id;
        this.code = code;
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        Seat seat = (Seat) o;
        return Objects.equals(id, seat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
