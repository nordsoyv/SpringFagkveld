package no.visma.sirius.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import no.visma.sirius.domain.Book;

@Repository
public class BookRepository {

	private int lastUsedId = 0;
	private List<Book> books; 
	
	
	public BookRepository() {
		books = new ArrayList<Book>();
		books.add(new Book("Spring IN ACTION", "Craig Walls"));
		books.add(new Book("Trist som faen", "Ari Behn"));
		books.add(new Book("Hodejegerne", "Jo Nesbø"));
	}
	
	public List<Book> getAllBooks()
	{
		return Collections.unmodifiableList(books);
	}
	
	public void addBook(Book book) {
		book.setId(lastUsedId++);
		books.add(book);
	}
	
	private int getBookPlacement(int bookId) {
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).getId() == bookId) {
				return i;
			}
		}
		return -1;
	}
	
	public Book getBook(int bookId) {
		return books.get(getBookPlacement(bookId));
	}
	
	public boolean removeBook(int bookId) {
		int bookPlacement = getBookPlacement(bookId);
		if(bookPlacement == -1) {
			return false;
		} else {
			books.remove(bookPlacement);
			return true;
		}
	}
	
	public Book updateBook(Book book) {
		int bookPlacement = getBookPlacement(book.getId());
		if(bookPlacement == -1) {
			return null;
		} else {
			books.remove(bookPlacement);
			books.add(book);
			return book;
		}
	}
}
