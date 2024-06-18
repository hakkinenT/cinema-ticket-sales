package com.hakkinenT.cinema_ticket_sales.services;

import com.hakkinenT.cinema_ticket_sales.models.dto.ScreeningRoomDTO;
import com.hakkinenT.cinema_ticket_sales.models.embedded.Seat;
import com.hakkinenT.cinema_ticket_sales.models.entities.ScreeningRoom;
import com.hakkinenT.cinema_ticket_sales.repositories.ScreeningRoomRepository;
import com.hakkinenT.cinema_ticket_sales.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningRoomService {
    @Autowired
    private ScreeningRoomRepository roomRepository;


    public List<ScreeningRoomDTO> findAll(){
        List<ScreeningRoom> rooms = roomRepository.findAll();
        return rooms.stream().map(ScreeningRoomDTO::new).toList();
    }

    public ScreeningRoomDTO findById(Integer roomNumber){
        ScreeningRoom room = roomRepository.findById(roomNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Esta sala não existe."));

        return new ScreeningRoomDTO(room);
    }

    public ScreeningRoomDTO insert(ScreeningRoomDTO dto){
        ScreeningRoom room = new ScreeningRoom();
        room.setRoomNumber(dto.getRoomNumber());
        room.setCapacity(dto.getCapacity());

        for (Seat seat : dto.getSeats()){
            room.getSeats().add(seat);
        }

        room = roomRepository.insert(room);

        return new ScreeningRoomDTO(room);
    }

    public ScreeningRoomDTO update(Integer roomNumber, ScreeningRoomDTO dto){
        ScreeningRoom room = roomRepository.findById(roomNumber).orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada"));
        room.setRoomNumber(dto.getRoomNumber());
        room.setCapacity(dto.getCapacity());

        room.getSeats().clear();
        for (Seat seat : dto.getSeats()){
            room.getSeats().add(seat);
        }

        room = roomRepository.save(room);

        return new ScreeningRoomDTO(room);
    }

    public void delete(Integer roomNumber){
        roomRepository.deleteById(roomNumber);
    }
}
