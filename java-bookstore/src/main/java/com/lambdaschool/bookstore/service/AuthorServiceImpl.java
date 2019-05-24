package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.exception.ResourceNotFoundException;
import com.lambdaschool.bookstore.model.Authors;
import com.lambdaschool.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AuthorServiceImpl implements AuthorService
{
	@Autowired
	private AuthorRepository authorRepository;
	@Override
	public void delete(long id)
	{

	}

	@Override
	public Authors findAuthorById(long id) throws ResourceNotFoundException
	{
		return authorRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("Could not find author with id " + id));
	}

	@Override
	public void save(Authors author)
	{

	}

	@Override
	public void update(Authors author, long id)
	{

	}

	@Override
	public List<Authors> findAll(Pageable pageable)
	{
		List<Authors> authors = new ArrayList<>();
		authorRepository.findAll(pageable).iterator().forEachRemaining(authors::add);
		return authors;
	}
}
