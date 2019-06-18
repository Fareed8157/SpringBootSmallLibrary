package com.abcl.libmgmt.controllers.admin;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcl.libmgmt.model.Book;
import com.abcl.libmgmt.service.IBookService;

@Controller
public class EditBookInfoController {

	@Autowired
    IBookService bookService;

	
	@Autowired
	@Qualifier("bookValidator")
	Validator bookValidator;
	
	@InitBinder
	public void initbinder(WebDataBinder dataBinder) {
	    dataBinder.setValidator(bookValidator);
	}
	
    @GetMapping("/admin/library/editbookinfo/{isbin}")
    public ModelAndView getEditPage(@PathVariable("isbin") String isbinNo) {
        ModelAndView mv = new ModelAndView("admin/library/editbookinfo");
        Book book = bookService.findBookByIsbinNo(isbinNo);
        mv.addObject("book", book);
        return mv;
    }
    
    @PutMapping("/admin/library/editbookinfo/{isbin}")
    public ModelAndView updateBookInfo(@Valid @ModelAttribute("book") Book bookUpdate, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/admin/books");
        if (result.hasErrors()) {
            mv.setViewName("admin/library/editbookinfo");
            mv.addObject("book", bookUpdate);
            return mv;
        }
        bookService.saveBookRecord(bookUpdate);
        return mv;
    }
}
