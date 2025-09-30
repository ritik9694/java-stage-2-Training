package com.cognizant.boot.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
//@RequiredArgsConstructor
@NoArgsConstructor
public class Book {

	private Integer bookId;
	private String bookTitle;
	private Float bookPrice;
}
