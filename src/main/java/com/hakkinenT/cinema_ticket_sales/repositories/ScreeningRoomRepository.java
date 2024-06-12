package com.hakkinenT.cinema_ticket_sales.repositories;

import com.hakkinenT.cinema_ticket_sales.models.entities.ScreeningRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScreeningRoomRepository extends MongoRepository<ScreeningRoom, String> {
}
