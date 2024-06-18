package com.hakkinenT.cinema_ticket_sales.models.dto;

import com.hakkinenT.cinema_ticket_sales.models.embedded.Seat;
import com.hakkinenT.cinema_ticket_sales.models.entities.ScreeningRoom;

import java.util.ArrayList;
import java.util.List;

public class ScreeningRoomDTO {
    private Integer roomNumber;
    private Integer capacity;

    List<Seat> seats = new ArrayList<>();

    public ScreeningRoomDTO() {
    }

    public ScreeningRoomDTO(Integer roomNumber, Integer capacity, List<Seat> seats) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.seats = seats;
    }

    public ScreeningRoomDTO(ScreeningRoom entity) {
        roomNumber = entity.getRoomNumber();
        capacity = entity.getCapacity();
        for (Seat seat : entity.getSeats()) {
            this.getSeats().add(seat);
        }
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
