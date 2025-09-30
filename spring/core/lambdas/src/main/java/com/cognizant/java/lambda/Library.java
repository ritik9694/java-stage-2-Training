package com.cognizant.java.lambda;

import java.util.Comparator;
import java.util.List;

public class Library {

	public static void main(String[] args) {
		BookService libraryService = new BookService();
		List<Book> books = libraryService.getAllBooksInAscendingOrderOfId();
		//display all books using for loop
		
		
		
		/*
		 * for(Book book : books) { System.out.println(book); }
		 * 
		 * Comparator<Book> compRef = (b1, b2) ->
		 * b1.getBookTitle().compareTo(b2.getBookTitle());
		 * 
		 * books.sort(compRef);
		 */
		

			
			  System.out.println("\nBooks sorted by id:"); for (Book book : books) {
			  System.out.println(book); }
			  
			 

	}

}
