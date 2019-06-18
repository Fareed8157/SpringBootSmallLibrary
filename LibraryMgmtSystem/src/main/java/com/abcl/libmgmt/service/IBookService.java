package com.abcl.libmgmt.service;

import java.util.ArrayList;
import java.util.List;

import com.abcl.libmgmt.model.Book;

public interface IBookService {

	public default List<Book> getAllBooks() {
        return new ArrayList<>();
    }

    public default Book saveBookRecord(Book book) {
        return null;
    }

    public default Book findBookByIsbinNo(String isbinNo) {
        return null;
    }

    public default void deleteBookByIsbin(String isbinNo) {

    }

    public default List<Book> findBookByTitle(String title) {
        return new ArrayList<>();
    }
    
}
