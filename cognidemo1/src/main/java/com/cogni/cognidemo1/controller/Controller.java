package com.cogni.cognidemo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cogni.cognidemo1.model.Book;

@RestController
public class Controller {

	@RequestMapping(value = "getall",method = RequestMethod.GET)
	public Book getAll() {
		
		Book book=new Book();
		book.setBid(55453);
		book.setBookName("Treasure");
		book.setPrice(100);
		
		
		
		return book;
		
	}
	
}
