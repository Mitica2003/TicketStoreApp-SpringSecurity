package com.example.demo.service;

import com.example.demo.dto.TicketDTO;
import com.example.demo.model.Ticket;

import java.util.List;

public interface TicketService {

    TicketDTO getTicketById(Long id);

    List<TicketDTO> getAllTickets();

    TicketDTO addTicket(TicketDTO ticketDTO);

    TicketDTO updateTicket(Ticket ticket);

    void deleteTicketByID(Long id);
}
