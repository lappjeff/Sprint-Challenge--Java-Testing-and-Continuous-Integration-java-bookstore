package com.lambdaschool.bookstore.controller;


import com.lambdaschool.bookstore.model.Authors;
import com.lambdaschool.bookstore.service.AuthorService;
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

	//localhost:2019/authors/all
	@GetMapping(value = "all", produces = "application/json")
	public ResponseEntity<?> getAllAuthors(@PageableDefault Pageable pageable)
	{
		List<Authors> allAuthors = authorService.findAll(pageable);
		return new ResponseEntity<>(allAuthors, HttpStatus.OK);
	}
}
