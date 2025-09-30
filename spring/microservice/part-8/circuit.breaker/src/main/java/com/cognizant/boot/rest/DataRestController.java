package com.cognizant.boot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class DataRestController {

	@GetMapping(path = "/data")
	@CircuitBreaker(fallbackMethod = "getDataFromDB", name="dataCircuitBreaker")
	public String getDataFromRedis() {		
		System.out.println("*** redis() method called... ***");
		// TODO: Redis conn logic
		int n = 10 / 0;
		return "fetching from redis";
	}

	public String getDataFromDB(Throwable t) {
		System.out.println("*** db() method called... ***");
		// TODO : db logic
		return "fetching from DB";
	}

}