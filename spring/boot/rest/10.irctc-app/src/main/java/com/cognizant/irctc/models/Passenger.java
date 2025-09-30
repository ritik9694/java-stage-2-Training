package com.cognizant.irctc.models;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Passenger {

	private String passengerName;
	private String fromStation;
	private String toStation;	
	
	//@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate dateOfJourney;
	private String trainNo;
}
