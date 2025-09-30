package com.cognizant.boot.bms.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.boot.bms.entity.Book;
import com.cognizant.boot.bms.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepository;

	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	

	@Override
	public void addBook(Book book) {
		bookRepository.save(book);
		
	}

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

	
	@Override
	public Book getBookById(int id) {
		Optional<Book>  bookById=bookRepository.findById(id);
		return bookById.orElse(null);
	}
}
