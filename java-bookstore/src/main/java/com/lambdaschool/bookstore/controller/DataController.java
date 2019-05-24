package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.exception.ResourceNotFoundException;
import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class DataController
{
	@Autowired
	private BookService bookService;
	//localhost:2019/data/books/bookid
	@PutMapping(value = "/books/{bookid}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateBook(@PathVariable long bookid, @RequestBody Book updateBook) throws ResourceNotFoundException
	{
		bookService.update(updateBook, bookid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
