package com.cognizant.bookstore;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.bookstore.model.Book;
import com.cognizant.bookstore.service.BookService;


@SpringBootApplication
public class Application {

    private final BookService bookService;

    Application(BookService bookService) {
        this.bookService = bookService;
    }

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		BookService bookService = context.getBean(BookService.class);

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the Bookstore!");
		while (true) {
			System.out.println("\nChoose an option:");
			System.out.println("1. Add Book");
			System.out.println("2. View All Books");
			System.out.println("3. View Book by ID");
			System.out.println("4. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			switch (choice) {
			case 1:
				System.out.print("Enter Book ID: ");
				Long id = scanner.nextLong();
				scanner.nextLine();

				System.out.print("Enter Title: ");
				String title = scanner.nextLine();

				System.out.print("Enter Author: ");
				String author = scanner.nextLine();

				System.out.print("Enter Price: ");
				Double price = scanner.nextDouble();
				scanner.nextLine();

				Book book = new Book(id, title, author, price);
				bookService.addBook(book);
				System.out.println("Book added successfully!");
				break;

			case 2:
				System.out.println("All Books:");
				bookService.getAllBook().forEach(b -> System.out
						.println(b.getId() + ": " + b.getTitle() + " by " + b.getAuthor() + " - ₹" + b.getPrice()));
				break;

			case 3:
				System.out.print("Enter Book ID: ");
				Long bookId = scanner.nextLong();
				scanner.nextLine();

				try {
					Book foundBook = bookService.getBookById(bookId);
					System.out.println("Book Found: " + foundBook.getTitle() + " by " + foundBook.getAuthor() + " - ₹"
							+ foundBook.getPrice());
				} catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				System.out.println("Exiting... Goodbye!");
				return;

			default:
				System.out.println("Invalid choice. Try again.");

			}
		}
	}

}
