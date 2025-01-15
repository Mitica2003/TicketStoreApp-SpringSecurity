package com.example.demo.controller;

import com.example.demo.DemoSecurityOneApplication;
import com.example.demo.dto.TicketDTO;
import com.example.demo.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DeveloperController {

    private final TicketService ticketService;

    @GetMapping("/user")
    public String userPage(Model model, Authentication authentication) {
        if (authentication != null && authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("USER"))) {
            List<TicketDTO> tickets = ticketService.getAllTickets();
            model.addAttribute("users", tickets);
            model.addAttribute("title", "User Panel");
            return "user";
        }
        return "redirect:/";
    }

    @PostMapping("/user/tickets/add")
    public String addTicket(@ModelAttribute TicketDTO ticketDto) {
        ticketService.addTicket(ticketDto);
        return "redirect:/user";
    }

    @PostMapping("/user/tickets/delete")
    public String deleteTicket(@RequestParam Long id) {
        ticketService.deleteTicketByID(id);
        return "redirect:/user";
    }
}
