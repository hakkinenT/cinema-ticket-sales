package com.hakkinenT.cinema_ticket_sales.models.dto;

import com.hakkinenT.cinema_ticket_sales.models.entities.Gender;

public class GenderDTO {
    private String id;
    private String description;

    public GenderDTO() {
    }

    public GenderDTO(String id, String description) {
        this.id = id.replaceAll("\\s","").toLowerCase();
        this.description = description;
    }

    public GenderDTO(Gender entity) {
        id = entity.getId().replaceAll("\\s","").toLowerCase();
        description = entity.getDescription();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.replaceAll("\\s","").toLowerCase();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
