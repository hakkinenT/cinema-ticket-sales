package com.hakkinenT.cinema_ticket_sales.controllers;

import com.hakkinenT.cinema_ticket_sales.models.dto.SessionDTO;
import com.hakkinenT.cinema_ticket_sales.models.entities.id.SessionId;
import com.hakkinenT.cinema_ticket_sales.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/sessions")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @PostMapping
    public ResponseEntity<SessionDTO> insert(@RequestBody SessionDTO dto){
        dto = sessionService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getDate()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{date}/{roomNumber}/{movieId}")
    public ResponseEntity<SessionDTO> findById(@PathVariable("date") String date, @PathVariable("roomNumber") Integer roomNumber, @PathVariable("movieId") String movieId){
        SessionId id = new SessionId(LocalDateTime.parse(date), roomNumber, movieId);
        SessionDTO session = sessionService.findById(id);
        return ResponseEntity.ok(session);
    }

    @DeleteMapping("/{date}/{roomNumber}/{movieId}")
    public ResponseEntity<Void> delete(@PathVariable("date") String date, @PathVariable("roomNumber") Integer roomNumber, @PathVariable("movieId") String movieId){
        SessionId id = new SessionId(LocalDateTime.parse(date), roomNumber, movieId);
        sessionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{date}/{roomNumber}/{movieId}")
    public ResponseEntity<SessionDTO> update(
            @PathVariable("date") String date,
            @PathVariable("roomNumber") Integer roomNumber,
            @PathVariable("movieId") String movieId,
            @RequestBody SessionDTO dto){
        SessionId id = new SessionId(LocalDateTime.parse(date), roomNumber, movieId);
        SessionDTO session = sessionService.update(id, dto);
        return ResponseEntity.ok(session);
    }
}
