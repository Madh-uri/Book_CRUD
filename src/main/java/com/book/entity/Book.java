package com.book.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private BigDecimal price;

    private LocalDate publicationDate;

	public Book(String title, String author, BigDecimal price, LocalDate publicationDate) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.publicationDate = publicationDate;
	}
    
}
