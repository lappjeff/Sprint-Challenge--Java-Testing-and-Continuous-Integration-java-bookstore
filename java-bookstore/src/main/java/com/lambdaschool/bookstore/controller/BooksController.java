package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController
{
	@Autowired
	private BookService bookService;

	@GetMapping(value = "/all", produces = "application/json")
	public ResponseEntity<?> getAllBooks(@PageableDefault Pageable pageable)
	{
		List<Book> allBooks = bookService.findAll(pageable);
		return new ResponseEntity<>(allBooks, HttpStatus.OK);
	}
}
