package com.cognizant.boot.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCTS_MASTER")
public class Product {
	
	@Id
	
	//@GeneratedValue
		//@GeneratedValue(strategy = GenerationType.AUTO)
		//@GeneratedValue(strategy = GenerationType.IDENTITY)
		//@GeneratedValue(strategy = GenerationType.SEQUENCE)
		//@GeneratedValue(strategy = GenerationType.TABLE)
	
	
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pid_gen")
	//@SequenceGenerator(name = "pid_gen", sequenceName = "product_seq", initialValue = 1001, allocationSize = 1)
     private int productId;
     private String productName;
     private Float productPrice;
}
