package com.hakkinenT.cinema_ticket_sales.models.entities;

import com.hakkinenT.cinema_ticket_sales.models.enums.TicketType;

import java.util.Objects;

public class Ticket {
    private String id;
    private String seatCodeTicket;
    private TicketType type;

    public Ticket() {
    }

    public Ticket(String id, String seatCodeTicket, TicketType type) {
        this.id = id;
        this.seatCodeTicket = seatCodeTicket;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeatCodeTicket() {
        return seatCodeTicket;
    }

    public void setSeatCodeTicket(String seatCodeTicket) {
        this.seatCodeTicket = seatCodeTicket;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
