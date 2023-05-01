package com.book;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.book.entity.Book;
import com.book.service.BookServiceImpl;

@SpringBootApplication
public class CrudSpringJpaH2ProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CrudSpringJpaH2ProjectApplication.class, args);
		BookServiceImpl service = context.getBean(BookServiceImpl.class);

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please choose an option:");
			System.out.println("1. List all books");
			System.out.println("2. Add a new book");
			System.out.println("3. Update an existing book");
			System.out.println("4. Delete a book");
			System.out.println("5. Exit");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				List<Book> blist = service.getAllBooks();
				blist.forEach(b -> System.out.println(b));
				break;

			case 2:
				Book newBook = new Book();
				System.out.println("Enter title:");
				newBook.setTitle(sc.next());
				System.out.println("Enter author:");
				newBook.setAuthor(sc.next());
				System.out.println("Enter price:");
				newBook.setPrice(sc.nextBigDecimal());
				System.out.println("Enter publication date (YYYY-MM-DD):");
				newBook.setPublicationDate(LocalDate.parse(sc.next()));
				service.saveBook(newBook);
				System.out.println("Book added.");
				break;

			case 3:
				System.out.println("Enter book id:");
				Long id2 = sc.nextLong();
				Optional<Book> optionalB = service.getBookByID(id2);
				if (optionalB.isPresent()) {
					Book bookToUpdate = optionalB.get();
					System.out.println("Enter new title");
					String title = sc.next();
					if (!title.isEmpty()) {
						bookToUpdate.setTitle(title);
					}
					System.out.println("Enter new author");
					String author = sc.next();
					if (!author.isEmpty()) {
						bookToUpdate.setTitle(title);
					}
					System.out.println("Enter new price");
					String priceString = sc.next();
					if (!priceString.isEmpty()) {
						BigDecimal price = new BigDecimal(priceString);
						bookToUpdate.setPrice(price);
					}
					System.out.println("Enter new publication date");
					String publicationDateString = sc.next();
					if (!publicationDateString.isEmpty()) {
						LocalDate publicationDate = LocalDate.parse(publicationDateString);
						bookToUpdate.setPublicationDate(publicationDate);
					}
					service.saveBook(bookToUpdate);
					System.out.println("Book updated successfully.");
				} 
				else {
					System.out.println("Book not found with id " + id2);
				}
				break;

			case 4:
				System.out.println("Enter book id:");
				Long id1 = sc.nextLong();
				service.deleteBook(id1);
				System.out.println("Record deleted");
				break;

			case 5:
				System.out.println("Exiting application...");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}

		}


	}

}
