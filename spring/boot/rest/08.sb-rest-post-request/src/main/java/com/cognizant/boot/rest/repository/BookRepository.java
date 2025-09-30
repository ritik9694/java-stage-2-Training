package com.cognizant.boot.rest.repository;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.boot.rest.model.Book;

@Repository
public class BookRepository {

	public List<Book> getBook() {
		List<Book> books = new ArrayList<>();
		Book bk1 = new Book(1001, "Java Reference", 575.50f);
        Book bk2 = new Book(1002, "Python Reference", 750f);
        Book bk3 = new Book(1003, "Microservices Reference", 875.50f);
        Book bk4 = new Book(1004, "Spring with Spring Boot Reference", 1275.50f);
        
        books.add(bk1);
        books.add(bk2);
        books.add(bk3);
        books.add(bk4);
        
        return books;
		
	}
}
