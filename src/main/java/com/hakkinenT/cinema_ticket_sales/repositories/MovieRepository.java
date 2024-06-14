package com.hakkinenT.cinema_ticket_sales.repositories;

import com.hakkinenT.cinema_ticket_sales.models.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
