package com.cognizant.boot.bms.service;


import java.util.List;

import com.cognizant.boot.bms.entity.Book;

public interface BookService {

	 public void addBook(Book book);
	 
	 public List<Book> getAllBooks();
	 
	 Book getBookById(int id);

}
