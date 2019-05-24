package com.lambdaschool.bookstore.controller;


import com.lambdaschool.bookstore.model.Authors;
import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.model.ErrorDetail;
import com.lambdaschool.bookstore.service.AuthorService;
import io.swagger.annotations.*;
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
@RequestMapping("/authors")
public class AuthorsController
{
	@Autowired
	private AuthorService authorService;

		@ApiOperation(value = "Returns all authors, pageable")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Specifies the page " +
					"you want to access"),
			@ApiImplicitParam(name = "pageSize", dataType = "integer", paramType = "query", value = "Specifies the " +
					"amount of items per page"),
			@ApiImplicitParam(name = "sort", dataType = "string", allowMultiple =true, paramType = "query", value =
					"Sorts results by variable of choice")
					   })
	@ApiResponses({
			@ApiResponse(code = 200, message = "Request successful", response = Authors.class, responseContainer = "List"),
			@ApiResponse(code = 500, message = "Server down/request unsuccessful", response = ErrorDetail.class),
			@ApiResponse(code = 401, message = "Unauthorized request. Double check that you are logged in."),
			@ApiResponse(code = 404, message = "Resource not found.")
				  })
	//localhost:2019/authors/all
	@GetMapping(value = "all", produces = "application/json")
	public ResponseEntity<?> getAllAuthors(@PageableDefault Pageable pageable)
	{
		List<Authors> allAuthors = authorService.findAll(pageable);
		return new ResponseEntity<>(allAuthors, HttpStatus.OK);
	}
}
