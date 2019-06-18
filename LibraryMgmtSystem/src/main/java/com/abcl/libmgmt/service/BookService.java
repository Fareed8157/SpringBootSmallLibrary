package com.abcl.libmgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcl.libmgmt.model.Book;
import com.abcl.libmgmt.repository.BookRepository;

@Service("bookService")
public class BookService implements IBookService {

	@Autowired
    BookRepository bookRepository;

    /*
     * (non-Javadoc)
     *
     * @see com.abcl.libmgmt.service.IBookService#getAllBooks()
     */
    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll()
        .forEach(books::add);
        return books;
    }
    
    @Override
    public Book saveBookRecord(Book book) {
    	return bookRepository.save(book);
    }
    
    @Override
    public Book findBookByIsbinNo(String isbinNo) {
    	return bookRepository.findByIsbin(isbinNo);
    }
    
    public void deleteBookByIsbin(String isbinNo) {
    	Book book=bookRepository.findByIsbin(isbinNo);
    	bookRepository.delete(book);
    }
}
