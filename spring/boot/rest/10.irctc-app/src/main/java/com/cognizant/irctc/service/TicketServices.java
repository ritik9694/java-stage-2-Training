package com.cognizant.irctc.service;

import com.cognizant.irctc.entities.Ticket;
import com.cognizant.irctc.models.Passenger;

public interface TicketServices {
 public Ticket newBooking(Passenger passenger);
 public Ticket getTicketByPnr(String pnr);
 public Ticket updateTicket(String pnr, Passenger passenger);
 public boolean cancelTicket(String pnr);
 
}
