package com.abcl.libmgmt.controllers.admin;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcl.libmgmt.model.Book;
import com.abcl.libmgmt.service.IBookService;

@Controller
public class AddNewBookController {

	
	@Autowired
	IBookService bookService;
	
	@Autowired
	@Qualifier("bookValidator")
	Validator bookValidator;
	
	@InitBinder
	public void initbinder(WebDataBinder dataBinder) {
	    dataBinder.setValidator(bookValidator);
	    dataBinder.registerCustomEditor(Date.class,"publishDate", new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"),false));
	}
	 
	@GetMapping("/admin/addbook")
	public ModelAndView getIndexPage() {
		ModelAndView mv=new ModelAndView("admin/library/addbook");
		mv.addObject("book", new Book());
		return mv;
	}
	
	
	
	@PostMapping("/admin/addbook")
	public ModelAndView addBookRecord( @Valid @ModelAttribute("book") Book book,BindingResult result) {
		ModelAndView mv=new ModelAndView("redirect:/admin");
		if (result.hasErrors()) {
            mv.setViewName("admin/library/addbook");
            mv.addObject("book", book);
            return mv;
        }
		bookService.saveBookRecord(book);
		return mv;
	}
}
