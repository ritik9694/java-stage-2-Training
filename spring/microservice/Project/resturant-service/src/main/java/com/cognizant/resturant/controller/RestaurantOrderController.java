package com.cognizant.resturant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.resturant.dto.OrderResponseDTO;
import com.cognizant.resturant.repositry.OrderRepositry;
import com.cognizant.resturant.service.RestaurantOrderService;

@RestController
@RequestMapping("/restaurant/orders")
public class RestaurantOrderController {

   


	   @Autowired
	    private RestaurantOrderService restaurantOrderService;

	    @GetMapping("/{orderId}")
	    public OrderResponseDTO getOrder(@PathVariable String orderId) {
	        return restaurantOrderService.getOrderById(orderId);
	    }

	    @PostMapping
	    public OrderResponseDTO createOrder(@RequestBody OrderResponseDTO dto) {
	        return restaurantOrderService.createOrder(dto);
	    }

}
