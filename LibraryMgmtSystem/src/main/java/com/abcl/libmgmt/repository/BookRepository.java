package com.abcl.libmgmt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcl.libmgmt.model.Book;

@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {
	
	@Query("select o from Book o where isbin = :isbinNo")
    public Book findByIsbin(@Param("isbinNo") String isbinNo);

    @Query("select o from Book o where book_title like %:bookTitle%")
    public List<Book> findByBookTitle(@Param("bookTitle") String bookTitle);
    
}
