package com.hakkinenT.cinema_ticket_sales.controllers;

import com.hakkinenT.cinema_ticket_sales.models.dto.ScreeningRoomDTO;
import com.hakkinenT.cinema_ticket_sales.services.ScreeningRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class ScreeningRoomController {
    @Autowired
    private ScreeningRoomService roomService;

    @GetMapping
    public ResponseEntity<List<ScreeningRoomDTO>> findAll(){
        List<ScreeningRoomDTO> rooms = roomService.findAll();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{roomNumber}")
    public ResponseEntity<ScreeningRoomDTO> findById(@PathVariable Integer roomNumber){
        ScreeningRoomDTO room = roomService.findById(roomNumber);
        return ResponseEntity.ok(room);
    }

    @PostMapping
    public ResponseEntity<ScreeningRoomDTO> insert(@RequestBody ScreeningRoomDTO dto){
        dto = roomService.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{roomNumber}")
                .buildAndExpand(dto.getRoomNumber())
                .toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{roomNumber}")
    public ResponseEntity<ScreeningRoomDTO> update(@PathVariable Integer roomNumber, @RequestBody ScreeningRoomDTO dto){
        dto = roomService.update(roomNumber, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{roomNumber}")
    public ResponseEntity<ScreeningRoomDTO> delete(@PathVariable Integer roomNumber){
        roomService.delete(roomNumber);
        return ResponseEntity.noContent().build();
    }
}
