package com.cognizant.client;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cognizant.dto.OrderResponseDTO;

@Component
public class RestaurantServiceClient {

	@Autowired
	private RestTemplate restTemplate;
	
	public OrderResponseDTO fetchOrderStatus(String orderId) {
		return restTemplate.patchForObject("http://RESTAURANT-SERVICE/restaurant/orders/status/", orderId, OrderResponseDTO.class);
	}
}
