package com.hakkinenT.cinema_ticket_sales.services;

import com.hakkinenT.cinema_ticket_sales.models.dto.SessionDTO;
import com.hakkinenT.cinema_ticket_sales.models.entities.Session;
import com.hakkinenT.cinema_ticket_sales.models.entities.id.SessionId;
import com.hakkinenT.cinema_ticket_sales.repositories.SessionRepository;
import com.hakkinenT.cinema_ticket_sales.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public SessionDTO insert(SessionDTO dto){
        SessionId id = new SessionId(dto.getDate(), dto.getRoomNumber(), dto.getMovieId());
        Session session = new Session();
        session.setId(id);
        session.setFullTicketValue(dto.getFullTicketValue());
        session.setHalfTicketValue(dto.getHalfTicketValue());
        session.setClosed(dto.isClosed());

        session = sessionRepository.insert(session);

        return new SessionDTO(session);
    }

    public SessionDTO findById(SessionId id){
        Session session = sessionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sessão não encontrada"));
        return new SessionDTO(session);
    }

    public SessionDTO update(SessionId id, SessionDTO dto){
        Session session = sessionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sessão não encontrada"));
        sessionRepository.deleteById(id);
        SessionId newId = new SessionId(dto.getDate(), dto.getRoomNumber(), dto.getMovieId());

        session.setId(newId);
        session.setFullTicketValue(dto.getFullTicketValue());
        session.setHalfTicketValue(dto.getHalfTicketValue());
        session.setClosed(dto.isClosed());

        session = sessionRepository.insert(session);

        return new SessionDTO(session);
    }

    public void delete(SessionId id){
        sessionRepository.deleteById(id);
    }
}
