package com.hakkinenT.cinema_ticket_sales.repositories;

import com.hakkinenT.cinema_ticket_sales.models.entities.Session;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionRepository extends MongoRepository<Session, String> {

}
