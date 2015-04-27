package com.scanbuy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scanbuy.bean.BookInfo;
import com.scanbuy.service.BookService;
import com.scanbuy.addResponseHandler.AddResponse;

@RestController
public class SpringServiceController {
	
	BookService bookService=new BookService();
	AddResponse result= new AddResponse();
	@RequestMapping(value = "/addBook", method = { RequestMethod.GET,
			RequestMethod.POST }, headers = "Accept=application/json")
	public AddResponse addBook(@RequestParam("barcode") long id,
			@RequestParam("name") String name,
			@RequestParam("author") String author,
			@RequestParam("pageNum") int pageNum,
			@RequestParam("read") String read) {
		System.out.println(id + ":" + name + ":" + author + ":" + pageNum + ":"
				+ read);
		if(String.valueOf(id).length()>13){
			result.setRespMessage("Barcode greater than 12 digits");
			return result;
		}
		
	BookInfo book= new BookInfo();
		
		book.setBarcode(id);
		book.setNameOfBook(name);
		book.setAuthorName(author);
		book.setNumOfPages(pageNum);
		book.setRead(read);
		
		result=bookService.addBook(book);
		return result;

	}

}