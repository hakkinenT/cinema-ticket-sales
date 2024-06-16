package com.hakkinenT.cinema_ticket_sales.controllers;

import com.hakkinenT.cinema_ticket_sales.models.dto.GenderDTO;
import com.hakkinenT.cinema_ticket_sales.models.dto.MovieDTO;
import com.hakkinenT.cinema_ticket_sales.repositories.GenderRepository;
import com.hakkinenT.cinema_ticket_sales.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/genders")
public class GenderController {
    @Autowired
    private GenderService genderService;

    @GetMapping
    public ResponseEntity<List<GenderDTO>> findAll(){
        List<GenderDTO> gender = genderService.findAll();
        return ResponseEntity.ok(gender);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenderDTO> findById(@PathVariable String id){
        GenderDTO gender = genderService.findById(id);
        return ResponseEntity.ok(gender);
    }

    @PostMapping
    public ResponseEntity<GenderDTO> insert(@RequestBody GenderDTO dto){
        dto = genderService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenderDTO> update(@PathVariable String id, @RequestBody GenderDTO dto){
        dto = genderService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        genderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
