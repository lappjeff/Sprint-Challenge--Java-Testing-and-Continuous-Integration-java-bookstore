package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.Authors;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<Authors, Long>
{
}
