package com.example.demo.mapper;

import com.example.demo.dto.TicketDTO;
import com.example.demo.model.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketMapper {

    public TicketDTO ticketEntityToDto(Ticket ticket) {
        return TicketDTO.builder()
                .id(ticket.getId())
                .name(ticket.getName())
                .price(ticket.getPrice())
                .build();
    }

    public List<TicketDTO> ticketListEntityToDto(List<Ticket> tickets) {
        return tickets.stream()
                .map(this::ticketEntityToDto)
                .toList();
    }

    public Ticket ticketDtoToEntity(TicketDTO ticketDto) {
        return Ticket.builder()
                .id(ticketDto.id())
                .name(ticketDto.name())
                .price(ticketDto.price())
                .build();
    }

    public List<Ticket> ticketListDtoToEntity(List<TicketDTO> ticketDtos) {
        return ticketDtos.stream()
                .map(this::ticketDtoToEntity)
                .toList();
    }
}
