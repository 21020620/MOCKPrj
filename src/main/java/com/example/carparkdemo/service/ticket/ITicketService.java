package com.example.carparkdemo.service.ticket;

import com.example.carparkdemo.entities.Ticket;

public interface ITicketService {
    String getAllTickets();
    Ticket getTicketById(Long id);
    String addTicket(Ticket ticket);
    String deleteTicket(Long id);
}
