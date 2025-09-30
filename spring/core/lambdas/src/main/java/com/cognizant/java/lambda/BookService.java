package com.cognizant.java.lambda;


import java.util.Comparator;
import java.util.List;

public class BookService {
	public List<Book> getAllBooksInAscendingOrderOfId(){
		 BooksDAO bookDao = new BooksDAO();
		 
		 List<Book> bookList = bookDao.getAllBooks();
		 
		 Comparator<Book> compBook = (b1,b2) -> (b1.getBookId() > b2.getBookId()) ? 1:1;
		 bookList.sort(compBook);
		 
		 return bookList;
	}
}
