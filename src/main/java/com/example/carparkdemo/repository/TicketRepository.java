package com.example.carparkdemo.repository;

import com.example.carparkdemo.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
