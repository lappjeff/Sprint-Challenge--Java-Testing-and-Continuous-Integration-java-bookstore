package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BooksRepository extends PagingAndSortingRepository<Book, Long>
{
}
