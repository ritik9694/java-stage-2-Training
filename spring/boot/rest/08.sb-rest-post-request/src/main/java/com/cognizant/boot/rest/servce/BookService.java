package com.cognizant.boot.rest.servce;

import java.util.List;

import com.cognizant.boot.rest.model.Book;

public interface BookService {

	public boolean saveBooks(Book newBook);
	public Book findBookById(Integer bookId);
	public List<Book> findAll();
	public boolean deleteBookById(Integer bookId);
}
