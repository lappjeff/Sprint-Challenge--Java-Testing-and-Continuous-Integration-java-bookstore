package com.lambdaschool.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Authors extends Auditable
{
	@Id
	@GeneratedValue
	private long authorid;

	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false)
	private String firstname;

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties({"author", "book"})
	private List<AuthorBooks> authorBooks = new ArrayList<>();

	public Authors()
	{
	}

	public Authors(String lastname, String firstname)
	{
		this.lastname = lastname;
		this.firstname = firstname;
	}

	public long getAuthorid()
	{
		return authorid;
	}

	public void setAuthorid(long authorid)
	{
		this.authorid = authorid;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public List<AuthorBooks> getAuthorBooks()
	{
		return authorBooks;
	}

	public void setAuthorBooks(List<AuthorBooks> authorBooks)
	{
		this.authorBooks = authorBooks;
	}
}
