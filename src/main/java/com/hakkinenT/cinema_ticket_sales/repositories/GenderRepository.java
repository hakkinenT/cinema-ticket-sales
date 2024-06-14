package com.hakkinenT.cinema_ticket_sales.repositories;

import com.hakkinenT.cinema_ticket_sales.models.entities.Gender;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenderRepository extends MongoRepository<Gender, String> {
}
