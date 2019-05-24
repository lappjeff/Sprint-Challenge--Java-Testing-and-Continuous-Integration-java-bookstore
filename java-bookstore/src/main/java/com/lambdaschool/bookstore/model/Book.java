package com.lambdaschool.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book
{
	@Id
	@GeneratedValue
	private long bookid;

	@Column(nullable = false, unique = true)
	private String booktitle;
	private String ISBN;
	private int copyyear;

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties({"book", "author"})
	private List<AuthorBooks> bookAuthors = new ArrayList<>();

	public Book()
	{
	}

	public Book(String booktitle, String ISBN, int copyyear)
	{
		this.booktitle = booktitle;
		this.ISBN = ISBN;
		this.copyyear = copyyear;
	}

	public long getBookid()
	{
		return bookid;
	}

	public void setBookid(long bookid)
	{
		this.bookid = bookid;
	}

	public String getBooktitle()
	{
		return booktitle;
	}

	public void setBooktitle(String booktitle)
	{
		this.booktitle = booktitle;
	}

	public String getISBN()
	{
		return ISBN;
	}

	public void setISBN(String ISBN)
	{
		this.ISBN = ISBN;
	}

	public int getCopyyear()
	{
		return copyyear;
	}

	public void setCopyYear(int copy)
	{
		this.copyyear = copy;
	}

	public List<AuthorBooks> getBookAuthors()
	{
		return bookAuthors;
	}

	public void setBookAuthors(List<AuthorBooks> bookAuthors)
	{
		this.bookAuthors = bookAuthors;
	}
}
