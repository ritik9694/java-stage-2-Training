package com.cognizant.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.book.entity.Book;
import com.cognizant.book.service.impl.BookServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	//@PostMapping("/save")
	@PostMapping(produces = {"application/json","application/xml"},
			consumes = {"application/json","application/xml"})
	public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book){
		Book books = bookServiceImpl.saveBook(book);
		return new ResponseEntity<Book>(books,HttpStatus.CREATED);
	}
	
	@GetMapping(path="/{bookId}",
			produces = {"application/json","application/xml"})
	public ResponseEntity<Book> findBookByIds(@PathVariable int bookId){
		Book bookIds = bookServiceImpl.getBookById(bookId);
		if(bookIds != null) {
			return ResponseEntity.ok().body(bookIds);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Book>> findAll(){
		List<Book> books=bookServiceImpl.getAll();
		return ResponseEntity.ok(books);
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<Book> deleteBook(@PathVariable int bookId){
		boolean dltbk=bookServiceImpl.deleteById(bookId);
		if(dltbk) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}
	

	@PutMapping("{bookId}")
	public ResponseEntity<Book> updateBookId(@PathVariable int bookId,@RequestBody Book updatedBook){
		 boolean updtbk=bookServiceImpl.updateBook(bookId, updatedBook);
		if(updtbk) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}
}
