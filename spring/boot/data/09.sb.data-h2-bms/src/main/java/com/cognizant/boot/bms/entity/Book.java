package com.cognizant.boot.bms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_details")
public class Book {

	@Id
	//@GeneratedValue
		//@GeneratedValue(strategy = GenerationType.AUTO)
		//@GeneratedValue(strategy = GenerationType.IDENTITY)
		//@GeneratedValue(strategy = GenerationType.SEQUENCE)
		//@GeneratedValue(strategy = GenerationType.TABLE)
		
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_gen")
		@SequenceGenerator(name = "book_gen", sequenceName = "book_seq", initialValue = 1001, allocationSize = 1)
	  private Long id;
	  private String title;
	  private String author;
	  private Double price;
	  
	  



}
