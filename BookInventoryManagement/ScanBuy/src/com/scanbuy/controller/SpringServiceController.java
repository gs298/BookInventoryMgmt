package com.scanbuy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scanbuy.bean.BookInfo;
import com.scanbuy.service.BookService;

@RestController
public class SpringServiceController {
	
	BookService bookService=new BookService();

	@RequestMapping(value = "/addBook", method = { RequestMethod.GET,
			RequestMethod.POST }, headers = "Accept=application/json")
	public String addBook(@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("author") String author,
			@RequestParam("pageNum") int pageNum,
			@RequestParam("read") String read) {
		System.out.println(id + ":" + name + ":" + author + ":" + pageNum + ":"
				+ read);
		
	BookInfo book= new BookInfo();
		
		book.setBarcode(id);
		book.setNameOfBook(name);
		book.setAuthorName(author);
		book.setNumOfPages(pageNum);
		book.setRead(read);
		
		String result=bookService.addBook(book);
		return result;

	}

}