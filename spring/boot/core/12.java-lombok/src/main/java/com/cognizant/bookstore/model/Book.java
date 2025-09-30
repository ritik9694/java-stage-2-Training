package com.cognizant.bookstore.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

	private Long id;
	 private String title;
	 private String author;
	 private Double price;
}
