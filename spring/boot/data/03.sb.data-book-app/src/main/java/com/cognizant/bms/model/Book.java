package com.cognizant.bms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	 private String title;
	
	@Column(name = "author")
	 private String author;
	
	@Column(name = "price")
	 private Double price;
	 
	 
}
