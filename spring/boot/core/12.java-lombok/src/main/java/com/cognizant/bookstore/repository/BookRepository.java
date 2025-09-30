package com.cognizant.bookstore.repository;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cognizant.bookstore.model.Book;

@Repository
public class BookRepository {

	private final Map<Long,Book> bookMap = new HashMap<>();
	
	public void save(Book book) {
		bookMap.put(book.getId(), book);
	}
	
	public Collection<Book> findAll(){
		return bookMap.values();
	}
	
	public Optional<Book> findById(Long id){
		return Optional.ofNullable(bookMap.get(id));
	}
}
