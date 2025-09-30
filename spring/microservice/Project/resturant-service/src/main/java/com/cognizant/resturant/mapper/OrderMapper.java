package com.cognizant.resturant.mapper;

import com.cognizant.resturant.dto.OrderResponseDTO;
import com.cognizant.resturant.entity.Order;

public class OrderMapper {
  public static OrderResponseDTO toDto(Order order) {
	 return new OrderResponseDTO(

            order.getOrderId(),
            order.getName(),
            order.getQty(),
            order.getPrice(),
            order.getOrderDate(),
            order.getStatus(),
            order.getEstimateDeliveryWindow()

			 );
	
	  
  }
  

  public static Order toEntity(OrderResponseDTO dto) {
         return new Order(
             dto.getOrderId(),
             dto.getName(),
             dto.getQty(),
             dto.getPrice(),
             dto.getOrderDate(),
             dto.getStatus(),
             dto.getEstimateDeliveryWindow()
         );
     }

}
