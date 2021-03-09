package com.bookapphib.model.dao;

public interface BookDao {
	public void addBook(Book book);
	public Book getBookByIsbn(String isbn);

}
