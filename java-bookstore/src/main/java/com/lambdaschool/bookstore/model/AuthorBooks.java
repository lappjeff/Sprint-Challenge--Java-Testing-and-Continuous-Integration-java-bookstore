package com.lambdaschool.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "authorbooks")
public class AuthorBooks extends Auditable implements Serializable
{
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"authorBooks", "hibernateLazyInitializer"})
	@JoinColumn(name = "authorid")
	private Authors author;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"bookAuthors", "hibernateLazyInitializer"})
	@JoinColumn(name = "bookid")
	private Book book;

//	private String authorname;

	public AuthorBooks()
	{
	}

	public AuthorBooks(Authors author, Book book)
	{
		this.author = author;
		this.book = book;
		//todo Why is this returning null?
//		this.authorname = author.getFirstname() + author.getLastname();
	}

	public Authors getAuthor()
	{
		return author;
	}

	public void setAuthor(Authors author)
	{
		this.author = author;
	}

	public Book getBook()
	{
		return book;
	}

	public void setBook(Book book)
	{
		this.book = book;
	}

//	public String getAuthorname()
//	{
//		return authorname;
//	}
//
//	public void setAuthorname(String authorname)
//	{
//		this.authorname = authorname;
//	}


	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof AuthorBooks))
		{
			return false;
		}
		AuthorBooks that = (AuthorBooks) o;
		return Objects.equals(getAuthor(), that.getAuthor()) && Objects.equals(getBook(), that.getBook());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(getAuthor(), getBook());
	}
}
