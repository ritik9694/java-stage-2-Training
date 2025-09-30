package com.cognizant.boot.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Ticket {
	
	@Value("Pnr8688")
	private String pnr;
	@Value("${cts.psngName}")
	private String passengerName;
	@Override
	public String toString() {
		return "Ticket [pnr=" + pnr + ", passengerName=" + passengerName + "]";
	}

	
}
