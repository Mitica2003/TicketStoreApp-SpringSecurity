package com.example.demo.repository;

import com.example.demo.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // Căutare ticket după id
    Optional<Ticket> findById(Long id);

    // Returnează toate ticket-urile
    List<Ticket> findAll();

    // Verifică dacă un ticket cu un anumit nume există deja
    boolean existsByName(String name);

    // Poți adăuga și o interogare personalizată dacă este necesar
    @Query("SELECT t FROM Ticket t WHERE t.name = ?1")
    Optional<Ticket> findByName(String name);
}
