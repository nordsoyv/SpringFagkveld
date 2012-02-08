package com.visma.siriusit.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visma.siriusit.repository.BookRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/book")
public class BookController {
	
	
	@Autowired
	private BookRepository bookRepository; 
	
	
	@RequestMapping(value = "{bookId}", method=RequestMethod.GET)
	public String getBook(@PathVariable Integer bookId, ModelMap modelMap){

		modelMap.addAttribute("book", bookRepository.getBook(bookId)); 
		return "book"; 
	}
		
}
