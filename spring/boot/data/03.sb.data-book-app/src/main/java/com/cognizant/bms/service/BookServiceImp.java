package com.cognizant.bms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bms.repository.BookRepositry;

@Service
public class BookServiceImp implements BookService{

	@Autowired
	private final BookRepositry bookRepository;

	public BookServiceImp(BookRepositry bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	
	
}
