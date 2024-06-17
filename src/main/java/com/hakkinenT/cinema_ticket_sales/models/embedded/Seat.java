package com.hakkinenT.cinema_ticket_sales.models.embedded;

import com.hakkinenT.cinema_ticket_sales.models.entities.ScreeningRoom;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

public class Seat {
    private String code;


    public Seat() {
    }

    public Seat(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
