package com.example.demo.controller;

import com.example.demo.dto.TicketDTO;
import com.example.demo.service.TicketService;
import com.example.demo.service.UserService;
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
public class AdminController {

    private final TicketService ticketService;

    @GetMapping("/admin")
    public String adminPage(Model model, Authentication authentication) {
        if (authentication != null && authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ADMIN"))) {
            List<TicketDTO> tickets = ticketService.getAllTickets();
            model.addAttribute("tickets", tickets);
            model.addAttribute("title", "Admin Panel");
            return "admin";
        }
        return "redirect:/";
    }

    @PostMapping("/admin/tickets/add")
    public String addTicket(@ModelAttribute TicketDTO ticketDto) {
        ticketService.addTicket(ticketDto);
        return "redirect:/admin";
    }

    @PostMapping("/admin/tickets/delete")
    public String deleteTicket(@RequestParam Long id) {
        ticketService.deleteTicketByID(id);
        return "redirect:/admin";
    }
}
