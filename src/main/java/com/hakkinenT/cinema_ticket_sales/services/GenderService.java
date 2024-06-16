package com.hakkinenT.cinema_ticket_sales.services;

import com.hakkinenT.cinema_ticket_sales.models.dto.GenderDTO;
import com.hakkinenT.cinema_ticket_sales.models.entities.Gender;
import com.hakkinenT.cinema_ticket_sales.repositories.GenderRepository;
import com.hakkinenT.cinema_ticket_sales.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {
    @Autowired
    private GenderRepository genderRepository;

    public GenderDTO insert(GenderDTO dto){
        Gender gender = new Gender();
        gender.setId(dto.getId());
        gender.setDescription(dto.getDescription());

        gender = genderRepository.insert(gender);

        return new GenderDTO(gender);
    }

    public GenderDTO update(String id, GenderDTO dto){
        Gender gender = genderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genero não encontrado"));
        gender.setId(dto.getId());
        gender.setDescription(dto.getDescription());

        gender = genderRepository.save(gender);

        return new GenderDTO(gender);
    }

    public GenderDTO findById(String id){
        Gender gender = genderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genero não encontrado"));
        return new GenderDTO(gender);
    }

    public List<GenderDTO> findAll(){
        List<Gender> genders = genderRepository.findAll();
        return genders.stream().map(GenderDTO::new).toList();
    }

    public void delete(String id){
        genderRepository.deleteById(id);
    }
}
