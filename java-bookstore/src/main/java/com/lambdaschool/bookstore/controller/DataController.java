package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.exception.ResourceNotFoundException;
import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.model.ErrorDetail;
import com.lambdaschool.bookstore.service.BookService;
import io.swagger.annotations.*;
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

	@ApiOperation(value = "Updates a book. Currently adding authors is not supported.")
	@ApiResponses({
			@ApiResponse(code = 404, message = "Book id not found", response = ErrorDetail.class),
			@ApiResponse(code = 500, message = "Server down/request unsuccessful", response = ErrorDetail.class),
			@ApiResponse(code = 401, message = "Unauthorized request. Double check that you are logged in.")

	})
	@ApiImplicitParams({
			@ApiImplicitParam(name = "bookid", value = "Id of book being updated", required = true),
			@ApiImplicitParam(name = "updateBook", value = "Body of changes being made to targeted student",
							  required = true)
	})
	//localhost:2019/data/books/bookid
	@PutMapping(value = "/books/{bookid}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateBook(@PathVariable long bookid, @RequestBody Book updateBook) throws ResourceNotFoundException
	{
		bookService.update(updateBook, bookid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Adds a new book to a author based off of book id and author id")
	@ApiResponses({
			@ApiResponse(code = 404, message = "Book id not found", response = ErrorDetail.class),
			@ApiResponse(code = 500, message = "Server down/request unsuccessful", response = ErrorDetail.class),
			@ApiResponse(code = 401, message = "Unauthorized request. Double check that you are logged in.")

	})

	@ApiImplicitParams({
			@ApiImplicitParam(name = "bookid", value = "Id of book being added to author", required = true),
			@ApiImplicitParam(name = "authorid", value = "Id of author",
							  required = true)
	})


	//localhost:2019/data/addbooktoauthor/{bookid}/{authorid}
	//TODO how would I do this through a JSON body?
	@PostMapping(value = "/addbooktoauthor/{bookid}/{authorid}", consumes = "application/json", produces =
			"application/json")
	public ResponseEntity<?> addBookToAuthor(@PathVariable long bookid, @PathVariable long authorid)
	{
		bookService.assignBookToAuthor(bookid, authorid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Deletes a book/author combination based off of book id")

	@ApiResponses({
			@ApiResponse(code = 404, message = "Book id not found", response = ErrorDetail.class),
			@ApiResponse(code = 500, message = "Server down/request unsuccessful", response = ErrorDetail.class),
			@ApiResponse(code = 401, message = "Unauthorized request. Double check that you are logged in.")

	})

	@ApiImplicitParam(name = "bookid", value = "Id of book being deleted", required = true)
	//localhost:2019/data/{bookid}
	@DeleteMapping(value = "{bookid}")
	public ResponseEntity<?> deleteBook(@PathVariable long bookid)
	{
		bookService.delete(bookid);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
