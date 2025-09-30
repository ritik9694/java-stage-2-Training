package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.client.RestaurantServiceClient;
import com.cognizant.dto.OrderResponseDTO;

@Service
public class SwiggyAppService {

	@Autowired
	private RestaurantServiceClient restaurantService;
	
	public OrderResponseDTO checkOrderStatus(String orderId) {
		return restaurantService.fetchOrderStatus(orderId);
	}
}
