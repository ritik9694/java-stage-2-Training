package com.cognizant.bms.service;

import java.awt.print.Book;
import java.util.Collection;

public interface BookService {

	 public void addBook(Book book);
	 public Collection<Book> getAllBooks();
	 public Book getBookById(Long id);
}
