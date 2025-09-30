package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.dto.OrderResponseDTO;
import com.cognizant.service.SwiggyAppService;

@RestController
@RequestMapping("/swiggy")
public class SwiggyAppController {

	@Autowired
	private SwiggyAppService swiggyAppService;
	
	 @GetMapping("/{orderId}")
	public OrderResponseDTO chechkOrder(@PathVariable String orderId) {
		return swiggyAppService.checkOrderStatus(orderId);
	}
}
