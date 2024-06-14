package com.hakkinenT.cinema_ticket_sales.repositories;

import com.hakkinenT.cinema_ticket_sales.models.entities.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, String> {
}
