package com.bookapphib.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bookapphib.connections.HibSessionFactory;
import com.bookapphib.model.exceptions.DataAccessException;

public class BookDaoImpl implements BookDao {
	
	private SessionFactory factory;

	public BookDaoImpl() {
		factory = HibSessionFactory.getSessionfactory();
	}

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction transaction = session.getTransaction();
		
		try {
			transaction.begin();

			session.save(book);

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			throw new DataAccessException(e.getCause().getMessage());
		} finally {
			if (session != null)
				session.close();
		}
		
		
	}

	public Book getBookByIsbn(String isbn) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();

		Book book = session.get(Book.class, isbn);

		if (session != null) {
			session.close();
		}
		
		return book;
		
	}
	

}
