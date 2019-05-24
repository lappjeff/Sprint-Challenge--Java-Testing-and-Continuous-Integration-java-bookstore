package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.model.Role;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService
{
	void delete(long id);

	void assignBookToAuthor(long bookid, long authorid);

	Book save(Book book);

	Book update(Book book, long id);

	List<Book> findAll(Pageable pageable);

	Book findByBookId(long id);


}

