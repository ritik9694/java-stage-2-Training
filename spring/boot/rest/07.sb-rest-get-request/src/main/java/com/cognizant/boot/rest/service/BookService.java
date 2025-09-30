package com.cognizant.boot.rest.service;

import java.util.List;

import com.cognizant.boot.rest.entity.Book;

public interface BookService {

	public Book findBookById(Integer bookId);
	public List<Book> findAllBook();
}
