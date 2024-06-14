package com.hakkinenT.cinema_ticket_sales.config;

import com.hakkinenT.cinema_ticket_sales.models.embedded.Act;
import com.hakkinenT.cinema_ticket_sales.models.embedded.Actor;
import com.hakkinenT.cinema_ticket_sales.models.entities.*;
import com.hakkinenT.cinema_ticket_sales.repositories.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ScreeningRoomRepository roomRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @PostConstruct
    public void init(){
        seatRepository.deleteAll();
        roomRepository.deleteAll();
        genderRepository.deleteAll();
        movieRepository.deleteAll();
        sessionRepository.deleteAll();

        ScreeningRoom room1 = new ScreeningRoom(1, 100);
        ScreeningRoom room2 = new ScreeningRoom(2, 50);

        roomRepository.saveAll(Arrays.asList(room1, room2));

        Seat seat1 = new Seat(null, "001", room1);
        Seat seat2 = new Seat(null, "002", room1);
        Seat seat3 = new Seat(null, "001", room2);

        seatRepository.saveAll(Arrays.asList(seat1, seat2, seat3));

        Gender gender1 = new Gender(null, "FICÇÃO");
        Gender gender2 = new Gender(null, "ROMANCE");
        Gender gender3 = new Gender(null, "COMÉDIA");
        Gender gender4 = new Gender(null, "COMÉDIA ROMANTICA");

        genderRepository.saveAll(Arrays.asList(gender1, gender2, gender3, gender4));

        Act act1 = new Act("Cady Heron");
        Act act2 = new Act("Regina George");
        Act act3 = new Act("Gretchen Wieners");
        Act act4 = new Act("Karen Smith");

        Actor actor1 = new Actor("Lindsey Lohan", act1);
        Actor actor2 = new Actor("Rachel McAdams", act2);
        Actor actor3 = new Actor("Lacey Chabert", act3);
        Actor actor4 = new Actor("Amanda Seyfried", act4);


        Movie movie = new Movie(null, "Meninas Malvadas", "01:37:00", gender3);
        movie.getActors().addAll(Arrays.asList(actor1, actor2, actor3, actor4));

        movie = movieRepository.insert(movie);
        boolean isPresent = roomRepository.findById(room1.getRoomNumber()).isPresent();
        if(isPresent){
            room1 = roomRepository.findById(room1.getRoomNumber()).get();
        }

        Session session = new Session(null, LocalDateTime.of(2024, 6, 13, 10, 0, 0), 60.0, 30.0, false, movie, room1);
        sessionRepository.insert(session);


    }
}