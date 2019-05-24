package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.exception.ResourceNotFoundException;
import com.lambdaschool.bookstore.model.AuthorBooks;
import com.lambdaschool.bookstore.model.Authors;
import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class BookServiceImpl implements BookService
{

	@Autowired
	private BooksRepository booksRepository;

	@Autowired
	private AuthorService authorService;

	@Transactional
	@Override
	public void delete(long id) throws ResourceNotFoundException
	{
		Book foundBook = findByBookId(id);

		if (foundBook == null)
		{
			throw new ResourceNotFoundException("Could not delete book with id " + id + " because book does not exist");
		}

		booksRepository.deleteBookFromAuthorBooks(id);
		booksRepository.delete(foundBook);
	}

	@Override
	public Book save(Book book)
	{
		return null;
	}

	@Transactional
	@Override
	public void assignBookToAuthor(long bookid, long authorid) throws ResourceNotFoundException
	{
		if(findByBookId(bookid) == null || authorService.findAuthorById(authorid) == null)
		{
			return;
		}

		booksRepository.addBookToAuthor(bookid, authorid);
	}

	@Transactional
	@Override
	public Book update(Book book, long id) throws ResourceNotFoundException
	{
		Book currentBook = findByBookId(id);

		if (book.getBooktitle() != null)
		{
			currentBook.setBooktitle(book.getBooktitle());
		}

		if (book.getISBN() != null)
		{
			currentBook.setISBN(book.getISBN());
		}

		//compares value of users book body's copy year and changes it if it does not match current books copy year
		if (book.getCopyyear() != currentBook.getCopyyear())
		{
			currentBook.setCopyYear(book.getCopyyear());
		}

		return booksRepository.save(currentBook);
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
		return booksRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Could not find book with an id of " + id));
	}
}
