package com.abcl.libmgmt.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcl.libmgmt.model.Book;
import com.abcl.libmgmt.service.IBookService;

@Controller
public class AdminBooksController {

	@Autowired
	private IBookService bookService;
	
	@GetMapping("admin/books")
	public ModelAndView getAllBooksPage() {
		List<Book> bookList=bookService.getAllBooks();
		ModelAndView mv=new ModelAndView("admin/library/allBooks");
		mv.addObject("books", bookList);
		return mv;
	}
}
