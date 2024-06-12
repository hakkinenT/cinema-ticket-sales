package com.hakkinenT.cinema_ticket_sales.config;

import com.hakkinenT.cinema_ticket_sales.models.entities.ScreeningRoom;
import com.hakkinenT.cinema_ticket_sales.models.entities.Seat;
import com.hakkinenT.cinema_ticket_sales.repositories.ScreeningRoomRepository;
import com.hakkinenT.cinema_ticket_sales.repositories.SeatRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ScreeningRoomRepository roomRepository;

    @PostConstruct
    public void init(){
        seatRepository.deleteAll();
        roomRepository.deleteAll();

        ScreeningRoom room1 = new ScreeningRoom(null, 1, 100);
        ScreeningRoom room2 = new ScreeningRoom(null, 2, 50);

        roomRepository.saveAll(Arrays.asList(room1, room2));

        Seat seat1 = new Seat(null, "001", room1);
        Seat seat2 = new Seat(null, "002", room1);
        Seat seat3 = new Seat(null, "001", room2);

        seatRepository.saveAll(Arrays.asList(seat1, seat2, seat3));
    }
}