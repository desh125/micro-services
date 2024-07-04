package com.example.ticket_service.service;


import com.example.ticket_service.dto.TicketDTO;

import java.util.List;

public interface TicketService {
    List<TicketDTO> getAllTickets();
    TicketDTO saveTicket(TicketDTO ticketDTO);
    void updateTicket(TicketDTO ticketDTO);
    void deleteTicket(TicketDTO ticketDTO);
    void updateTicketStatus(String ticketId, String status);
    TicketDTO findTicketById(String id);
}