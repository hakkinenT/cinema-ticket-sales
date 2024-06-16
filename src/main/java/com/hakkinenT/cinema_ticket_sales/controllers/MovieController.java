package com.hakkinenT.cinema_ticket_sales.controllers;

import com.hakkinenT.cinema_ticket_sales.models.dto.MovieDTO;
import com.hakkinenT.cinema_ticket_sales.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> findAll(){
        List<MovieDTO> movies = movieService.findAll();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable String id){
        MovieDTO movie = movieService.findById(id);
        return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<MovieDTO> insert(@RequestBody MovieDTO dto){
        dto = movieService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update(@PathVariable String id, @RequestBody MovieDTO dto){
        dto = movieService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
