package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository repository;

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<Book> getBookByID(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Book saveBook(Book b) {
		// TODO Auto-generated method stub
		return repository.save(b);
	}

	@Override
	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
