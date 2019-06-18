package com.abcl.libmgmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcl.libmgmt.model.Book;
import com.abcl.libmgmt.repository.BookRepository;

@Controller
public class AppController {

	@Autowired
	private BookRepository repo;
	
	@GetMapping("/app")
	public ModelAndView getIndexPage() {
		ModelAndView mv=new ModelAndView("app/index");
//		Iterable<Book> it=repo.findAll();
//		for(Book b: it) {
//			System.out.println(b.getBookTitle());
//		}
		return mv;
	}
}
