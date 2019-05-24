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

	//localhost:2019/data/addbooktoauthor/{bookid}/{authorid}
	//TODO how would I do this through a JSON body?
	@PostMapping(value = "/addbooktoauthor/{bookid}/{authorid}", consumes = "application/json", produces =
			"application/json")
	public ResponseEntity<?> addBookToAuthor(@PathVariable long bookid, @PathVariable long authorid)
	{
		bookService.assignBookToAuthor(bookid, authorid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//localhost:2019/data/{bookid}
	@DeleteMapping(value = "{bookid}")
	public ResponseEntity<?> deleteBook(@PathVariable long bookid)
	{
		bookService.delete(bookid);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
