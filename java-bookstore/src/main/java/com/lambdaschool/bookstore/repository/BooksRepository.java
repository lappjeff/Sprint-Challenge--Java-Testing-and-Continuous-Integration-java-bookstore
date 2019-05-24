package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface BooksRepository extends PagingAndSortingRepository<Book, Long>
{
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO authorbooks(bookid, authorid) VALUES (:bookid, :authorid)", nativeQuery = true)
	void addBookToAuthor(long bookid, long authorid);
}
