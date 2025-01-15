package com.example.demo.service;

import com.example.demo.dto.TicketDTO;
import com.example.demo.mapper.TicketMapper;
import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Override
    public TicketDTO getTicketById(Long id) {
        return ticketRepository.findById(id)
                .map(ticketMapper::ticketEntityToDto)
                .orElse(null);
    }

    @Override
    public List<TicketDTO> getAllTickets() {
        return ticketMapper.ticketListEntityToDto(ticketRepository.findAll());
    }

    @Override
    public TicketDTO addTicket(TicketDTO ticketDTO) {
        // Convertește TicketDTO într-o entitate Ticket
        Ticket ticket = ticketMapper.ticketDtoToEntity(ticketDTO);

        // Salvează Ticket-ul în baza de date
        Ticket savedTicket = ticketRepository.save(ticket);

        // Convertește Ticket-ul salvat înapoi într-un TicketDTO
        return ticketMapper.ticketEntityToDto(savedTicket);
    }


    @Override
    public TicketDTO updateTicket(Ticket ticket) {
        return ticketMapper.ticketEntityToDto(ticketRepository.save(ticket));
    }

    @Override
    public void deleteTicketByID(Long id) {
        ticketRepository.deleteById(id);
    }
}
