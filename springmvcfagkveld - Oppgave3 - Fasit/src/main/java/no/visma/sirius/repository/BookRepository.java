package no.visma.sirius.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import no.visma.sirius.domain.Book;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

	private int lastUsedId = 0;
	private List<Book> books;

	public BookRepository() {
		books = new ArrayList<Book>();
		addBook(new Book("Spring IN ACTION", "Craig Walls"));
		addBook(new Book("Trist som faen", "Ari Behn"));
		addBook(new Book("Hodejegerne", "Jo Nesbø"));
	}

	public List<Book> getAllBooks() {
		return Collections.unmodifiableList(books);
	}

	public void addBook(Book book) {
		book.setId(lastUsedId++);
		books.add(book);
	}

	private int getBookPlacement(int bookId) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == bookId) {
				return i;
			}
		}
		return -1;
	}

	public Book getBook(int bookId) {
		int bookPlacement = getBookPlacement(bookId);
		if (bookPlacement == -1) {
			return null;
		} else {
			return books.get(getBookPlacement(bookId));
		}
	}

	public boolean removeBook(int bookId) {
		int bookPlacement = getBookPlacement(bookId);
		if (bookPlacement == -1) {
			return false;
		} else {
			books.remove(bookPlacement);
			return true;
		}
	}

	public Book updateBook(Book book) {
		int bookPlacement = getBookPlacement(book.getId());
		if (bookPlacement == -1) {
			return null;
		} else {
			books.remove(bookPlacement);
			books.add(book);
			return book;
		}
	}
}
