package com.abcl.libmgmt.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abcl.libmgmt.model.Book;
import com.abcl.libmgmt.service.IBookService;

@RestController
public class AdminBooksRestController {

	@Autowired
    IBookService bookService;

    @GetMapping("admin/booksasjson")
    public List<Book> getAllBooksAsJson(@Nullable @RequestParam("search_keyword") String searchKeyword) {
        List<Book> booksList = null;
        if (null == searchKeyword || searchKeyword.isEmpty()) {
            booksList = bookService.getAllBooks();
        } else {
            booksList = bookService.findBookByTitle(searchKeyword);
        }

        return booksList;
    }
}
