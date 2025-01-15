package com.example.demo.dto;

import lombok.Builder;
import java.math.BigDecimal;

@Builder
public record TicketDTO(
        Long id,
        String name,
        Double price
) {}
