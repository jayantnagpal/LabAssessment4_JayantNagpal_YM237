package com.bookapphib.model.service;

import com.bookapphib.model.dao.Book;
import com.bookapphib.model.dao.BookDao;
import com.bookapphib.model.dao.BookDaoImpl;

public class BookAppHibService {
private BookDao bookDao;
	
	
	
	public BookAppHibService() {
		this.bookDao = new BookDaoImpl();
	}

	public void persistObjectGraph(Book book) {
		bookDao.addBook(book);
	}
	
	public Book retrieveObjectGraph(String isbn) {
		return bookDao.getBookByIsbn(isbn);
	}

}


