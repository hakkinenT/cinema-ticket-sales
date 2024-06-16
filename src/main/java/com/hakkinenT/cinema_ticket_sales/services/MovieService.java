package com.hakkinenT.cinema_ticket_sales.services;

import com.hakkinenT.cinema_ticket_sales.models.dto.MovieDTO;
import com.hakkinenT.cinema_ticket_sales.models.embedded.Actor;
import com.hakkinenT.cinema_ticket_sales.models.entities.Gender;
import com.hakkinenT.cinema_ticket_sales.models.entities.Movie;
import com.hakkinenT.cinema_ticket_sales.repositories.GenderRepository;
import com.hakkinenT.cinema_ticket_sales.repositories.MovieRepository;
import com.hakkinenT.cinema_ticket_sales.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenderRepository genderRepository;

    public List<MovieDTO> findAll(){
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(MovieDTO::new).toList();
    }

    public MovieDTO findById(String id){
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado."));

        return new MovieDTO(movie);
    }

    public MovieDTO insert(MovieDTO dto){
        Movie movie = new Movie();
        movie.setId(dto.getId());
        movie.setTitle(dto.getTitle());
        movie.setDuration(dto.getDuration());

        for (Actor actor : dto.getActors()){
            movie.getActors().add(actor);
        }

        Gender gender = genderRepository.findById(dto.getGender().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Gênero não encontrado."));

        movie.setGender(gender);

        movie = movieRepository.insert(movie);

        return new MovieDTO(movie);
    }

    public MovieDTO update(String id, MovieDTO dto){
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado"));
        movie.setId(dto.getId());
        movie.setTitle(dto.getTitle());
        movie.setDuration(dto.getDuration());

        movie.getActors().clear();
        for (Actor actor : dto.getActors()){
            movie.getActors().add(actor);
        }

        Gender gender = genderRepository.findById(dto.getGender().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Gênero não encontrado."));

        movie.setGender(gender);

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }

    public void delete(String id){
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado"));

        movieRepository.deleteById(movie.getId());
    }
}
