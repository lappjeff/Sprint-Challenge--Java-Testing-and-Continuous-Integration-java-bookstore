package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.model.Authors;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface AuthorService
{
	void delete(long id);

	void save(Authors author);

	void update(Authors author, long id);

	Authors findAuthorById(long id);

	List<Authors> findAll(Pageable pageable);
}
