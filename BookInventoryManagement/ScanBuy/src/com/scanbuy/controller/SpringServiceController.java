package com.scanbuy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scanbuy.bean.BookInfo;
import com.scanbuy.service.BookService;
import com.scanbuy.ResponseHandler.AddResponse;
import com.scanbuy.ResponseHandler.GetResponse;

@RestController
public class SpringServiceController {

	BookService bookService = new BookService();

	/*********** Request mapping for adding book, which take 5 RquestParameters *********/

	@RequestMapping(value = "/addBook", method = { RequestMethod.GET,
			RequestMethod.POST }, headers = "Accept=application/json")
	public AddResponse addBook(@RequestParam("barcode") long id,
			@RequestParam("name") String name,
			@RequestParam("author") String author,
			@RequestParam("pageNum") int pageNum,
			@RequestParam("read") String read) {

		AddResponse result = new AddResponse();

		if (String.valueOf(id).length() > 13) {
			result.setRespMessage("Barcode greater than 12 digits");
			return result;
		}
		else if (String.valueOf(id).length() < 5) {
			result.setRespMessage("Barcode should be minimum 5 digits");
			return result;
		}

		BookInfo book = new BookInfo();

		book.setBarcode(id);
		book.setNameOfBook(name);
		book.setAuthorName(author);
		book.setNumOfPages(pageNum);
		book.setRead(read);

		result = bookService.addBook(book);
		return result;

	}

	/*********** Request mapping for getting book, which takes 1 RquestParameters 
	 **********/

	@RequestMapping(value = "/getBookInfo", method = { RequestMethod.GET,
			RequestMethod.POST }, headers = "Accept=application/json")
	public GetResponse getUser(@RequestParam("barcode") long id,HttpServletResponse response){

		GetResponse book = bookService.getBookInfo(id);
		if (response.getStatus() == 200) {
            System.out.println("Status 200");
        }
		return book;
	}
	
	/*********** Request mapping for deleting book, which takes 1 RquestParameters *********/
	@RequestMapping(value = "/deleteBook", method = { RequestMethod.GET,
			RequestMethod.POST },headers="Accept=application/json")
	public void deleteUser(@RequestParam("barcode") long id) {
		System.out.println("Hi I am in deleteUser");
		
		bookService.deleteUser(id);
		//return user;
	}

}