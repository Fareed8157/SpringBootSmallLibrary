package com.abcl.libmgmt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name="book")
@Data
public class Book {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @Column(name = "book_title")
	    @NotNull
	    private String bookTitle;

	    @Column(name = "isbin")
	    @NotNull
	    private String isbin;

	    @Column(name = "authors")
	    @NotNull
	    private String authors;

	    @Column(name = "publish_date")
	    @NotNull
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date publishDate;

	    @Column(name = "publisher")
	    @NotNull
	    private String publisher;

	    @Column(name = "price")
	    @NotNull
	    private Double price;

	    @Column(name = "stock")
	    @NotNull
	    private Integer stock;

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			if (authors == null) {
				if (other.authors != null)
					return false;
			} else if (!authors.equals(other.authors))
				return false;
			if (bookTitle == null) {
				if (other.bookTitle != null)
					return false;
			} else if (!bookTitle.equals(other.bookTitle))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (isbin == null) {
				if (other.isbin != null)
					return false;
			} else if (!isbin.equals(other.isbin))
				return false;
			if (price == null) {
				if (other.price != null)
					return false;
			} else if (!price.equals(other.price))
				return false;
			if (publishDate == null) {
				if (other.publishDate != null)
					return false;
			} else if (!publishDate.equals(other.publishDate))
				return false;
			if (publisher == null) {
				if (other.publisher != null)
					return false;
			} else if (!publisher.equals(other.publisher))
				return false;
			if (stock == null) {
				if (other.stock != null)
					return false;
			} else if (!stock.equals(other.stock))
				return false;
			return true;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((authors == null) ? 0 : authors.hashCode());
			result = prime * result + ((bookTitle == null) ? 0 : bookTitle.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((isbin == null) ? 0 : isbin.hashCode());
			result = prime * result + ((price == null) ? 0 : price.hashCode());
			result = prime * result + ((publishDate == null) ? 0 : publishDate.hashCode());
			result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
			result = prime * result + ((stock == null) ? 0 : stock.hashCode());
			return result;
		}
	    
	    
}
