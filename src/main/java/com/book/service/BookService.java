package com.book.service;

import java.util.List;
import java.util.Optional;

import com.book.entity.Book;

public interface BookService {

	List<Book> getAllBooks();
	
	Optional<Book> getBookByID(Long id);
	
	Book saveBook(Book b);
	
	void deleteBook(Long id);
}
