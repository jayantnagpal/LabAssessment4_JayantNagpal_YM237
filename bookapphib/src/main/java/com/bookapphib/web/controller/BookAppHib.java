package com.bookapphib.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.bookapphib.model.dao.Book;
import com.bookapphib.model.dao.Chapter;
import com.bookapphib.model.dao.Publisher;
import com.bookapphib.model.service.BookAppHibService;

public class BookAppHib {
	public static void main(String[] args) {
		BookAppHibService bookAppHibService = new BookAppHibService();

		
		Publisher publisher = new Publisher("PENG", "Penguin");

		Book book = new Book("QW57", "Pride and Prejudice", publisher);

		List<Chapter> chapters = new ArrayList<Chapter>();
		Chapter chapter1 = new Chapter("A New Neighbor", 1);
		chapters.add(chapter1);
		Chapter chapter2 = new Chapter("Netherfield Hall", 2);
		chapters.add(chapter2);

		book.setChapters(chapters);

		bookAppHibService.persistObjectGraph(book);

//		Book book = bookAppHibService.retrieveObjectGraph("QW57");
//		System.out.println(book);

	}

}
