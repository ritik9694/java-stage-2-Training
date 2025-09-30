package com.cognizant.boot.bms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.boot.bms.entity.Book;
import com.cognizant.boot.bms.service.BookServiceImpl;

@SpringBootApplication
public class Application implements CommandLineRunner{
	private BookServiceImpl bookServiceImpl;
	

	@Autowired
	public Application(BookServiceImpl bookServiceImpl) {
		super();
		this.bookServiceImpl = bookServiceImpl;
	}


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {



        Book book1 = new Book(null, "Spring Boot Essentials", "Hrithik Kumar", 499.99);
        Book book2 = new Book(null, "Java Mastery", "Rupak", 799.99);
        Book book3 = new Book(null, "Clean Code", "Robert C. Martin", 699.99);


	    bookServiceImpl.addBook(book1);
	    bookServiceImpl.addBook(book2);
	    bookServiceImpl.addBook(book3);

	    System.out.println("Books added successfully!");

	 // Retrieving all books
	    List<Book> listBook=bookServiceImpl.getAllBooks();
	    System.out.println("All Books: ");
	    listBook.forEach(System.out::println);
	    
	 // Retrieving book by ID
	    int id = 1001;
	    Book bookId =bookServiceImpl.getBookById(id);
	    if(bookId != null) {
	    	System.out.println("Book with id: " + id + " Found "+ bookId);
	    }else {
	    	System.out.println("Book with id: " + id + " Not Found");
	    }
	}

}
