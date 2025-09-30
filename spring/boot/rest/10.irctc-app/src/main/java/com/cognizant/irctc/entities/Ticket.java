package com.cognizant.irctc.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Ticket {

	@Id
	private String pnr;
	
	private String passengerName;
	private String fromStation;
	private String toStation;	
	
	//@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate dateOfJourney;
	
	private String trainNo;
	
	//@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate dateOfBooking;
	
	private String bookingStatus;
	private Float ticketFare;
}
