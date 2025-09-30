package com.cognizant.book.entity;

import java.time.LocalDate;

import com.cognizant.book.controller.adapter.LocalDateAdapter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorOrder;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
	
	@Id
	@NotNull(message = "required")
	private int bookId;
	

   @NotBlank(message = "bookAuthor is Required")
	private String bookAuthor;
	
	@NotBlank(message = "bookTitle is Required")
	private String  bookTitle;
	
	@NotBlank(message = "bookPrice is Required")
	private String bookPrice;
	
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	@Future
	private LocalDate localDate;

}
