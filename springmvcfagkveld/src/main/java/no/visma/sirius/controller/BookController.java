package no.visma.sirius.controller;

import java.util.ArrayList;
import java.util.List;

import no.visma.sirius.domain.Book;
import no.visma.sirius.repository.BookRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BookController {

	private static final Logger logger = LoggerFactory
			.getLogger(BookController.class);

	@Autowired
	private BookRepository bookRepository;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model) {
		model.addAttribute("book", new Book());
		return "home";
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getBooks(ModelMap model) {

		model.addAttribute("books", bookRepository.getAllBooks());

		return "allBooks";
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public String getBook(ModelMap model, @PathVariable("id") Integer id) {
		List<Book> books = new ArrayList<Book>();
		books.add(bookRepository.getBook(id));
		model.addAttribute("books", books);
		return "allBooks";
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	public String deleteBook(ModelMap model, @PathVariable("id") Integer id) {
		bookRepository.removeBook(id);
		
		return "redirect:/";
	}

	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(ModelMap model, @ModelAttribute("book") Book book) {

		bookRepository.addBook(book);

		return "redirect:/";
	}
	
	@RequestMapping(value ="/books/{id}", method = RequestMethod.PUT)
	public  @ResponseBody Book updateBook(@RequestBody Book book ,@PathVariable("id") Integer id){
		Book oldBook = bookRepository.getBook(id);
		oldBook.setAuthor(book.getAuthor());
		oldBook.setTitle(book.getTitle());
		return oldBook;
	}
	
}
