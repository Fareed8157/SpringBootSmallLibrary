package com.abcl.libmgmt.model.validators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.abcl.libmgmt.model.Book;

@Component
@Qualifier("bookValidator")
public class BookValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(Book.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookTitle", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbin", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publishDate", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "authors", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stock", "msg.field.required");
	}

}
