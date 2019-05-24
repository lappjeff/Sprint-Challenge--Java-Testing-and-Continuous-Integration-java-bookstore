package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.exception.ResourceNotFoundException;
import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService
{

	@Autowired
	private BooksRepository booksRepository;

	@Override
	public void delete(long id) throws ResourceNotFoundException
	{

	}

	@Override
	public void save(Book book)
	{

	}

	@Override
	public void update(Book book, long id) throws ResourceNotFoundException
	{

	}

	@Override
	public List<Book> findAll(Pageable pageable)
	{
		List<Book> books = new ArrayList<>();
		booksRepository.findAll(pageable).iterator().forEachRemaining(books::add);
		return books;
	}

	@Override
	public Book findByBookId(long id) throws ResourceNotFoundException
	{
		return null;
	}
}
