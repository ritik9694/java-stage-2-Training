package com.cognizant.bookstore.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bookstore.model.Book;
import com.cognizant.bookstore.repository.BookRepository;

@Service
public class BookService {
	
	private BookRepository bookRepository;

	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	
	//add a book

	public void addBook(Book book) {
		bookRepository.save(book);
	}
	// Get all books
	public Collection<Book> getAllBook(){
		return bookRepository.findAll();
	}
    // Get book by ID


	public Book getBookById(Long id){
		return bookRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Book not found"));
	}

}
