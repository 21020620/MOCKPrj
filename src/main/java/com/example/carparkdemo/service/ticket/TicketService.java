package com.example.carparkdemo.service.ticket;

import com.example.carparkdemo.entities.Ticket;
import com.example.carparkdemo.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService{
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public String getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        StringBuilder sb = new StringBuilder();
        tickets.forEach(ticket -> sb.append(ticket.toString()).append("\n"));
        return sb.toString();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    public String addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
        return "Ticket added";
    }

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    public String deleteTicket(Long id) {
        boolean exists = ticketRepository.existsById(id);
        if (!exists) {
            return "Ticket with id " + id + " does not exist";
        }
        ticketRepository.deleteById(id);
        return "Ticket removed: " + id;
    }
}
