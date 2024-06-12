package com.hakkinenT.cinema_ticket_sales.repositories;

import com.hakkinenT.cinema_ticket_sales.models.entities.Seat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeatRepository extends MongoRepository<Seat, String> {
}
