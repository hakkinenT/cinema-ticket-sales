package com.hakkinenT.cinema_ticket_sales.models.entities;

import com.hakkinenT.cinema_ticket_sales.models.entities.id.SessionId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sessions")
public class Session {
    @Id
    private SessionId id;
    private Double fullTicketValue;
    private Double halfTicketValue;
    private boolean closed;

    public Session() {
    }

    public Session(SessionId id, Double fullTicketValue, Double halfTicketValue) {
        this.id = id;
        this.fullTicketValue = fullTicketValue;
        this.halfTicketValue = halfTicketValue;
    }

    public Session(SessionId id, Double fullTicketValue, Double halfTicketValue, boolean closed) {
        this.id = id;
        this.fullTicketValue = fullTicketValue;
        this.halfTicketValue = halfTicketValue;
        this.closed = closed;
    }

    public SessionId getId() {
        return id;
    }

    public void setId(SessionId id) {
        this.id = id;
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
