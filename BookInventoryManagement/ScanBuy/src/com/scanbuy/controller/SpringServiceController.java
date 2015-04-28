package com.scanbuy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.scanbuy.bean.BookInfo;
import com.scanbuy.service.BookService;
import com.scanbuy.ResponseHandler.AddResponse;
import com.scanbuy.ResponseHandler.DeleteResponse;
import com.scanbuy.ResponseHandler.GetResponse;


@Controller

public class SpringServiceController {
	
	BookService bookService = new BookService();
	
	/*********** Request mapping for adding book, which take 5 RquestParameters *********/

	@RequestMapping(value = "/addBook", method = { RequestMethod.GET,
			RequestMethod.POST }, headers = "Accept=application/json")
	public @ResponseBody AddResponse addBook(@RequestParam("barcode") long id,
			@RequestParam("name") String name,
			@RequestParam("author") String author,
			@RequestParam("pageNum") int pageNum,
			@RequestParam("read") String read) {

		AddResponse result = new AddResponse();
		int barcodeFlag=checkBarcode(id);
		
		if (barcodeFlag==0) {
			result.setRespMessage("Barcode greater than 12 digits");
			result.setStatusMessage("UNSUCCESSFUL");
			return result;
		}
		
		 if (name.equals("") || author.equals("") ||String.valueOf(pageNum).equals("") || read.equals("")) {
			result.setRespMessage("Please fill in the empty fields");
			result.setStatusMessage("UNSUCCESSFUL");
			return result;
		}
		
		 if (!read.equals("yes") 
				 &&!read.equals("YES") && !read.equals("Yes") 
				 && !read.equals("no") &&!read.equals("NO")&& !read.equals("No")) {
			result.setRespMessage("Read field accepts only YES/NO");
			result.setStatusMessage("UNSUCCESSFUL");
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
	public @ResponseBody GetResponse getUser(@RequestParam("barcode") long id){

        int barcodeFlag=checkBarcode(id);
		GetResponse resp=new GetResponse();
		if (barcodeFlag==0) {
			resp.setRespMessage("Barcode greater than 12 digits");
			resp.setStatusMessage("UNSUCCESSFUL");
			
		}
		resp = bookService.getBookInfo(id);
		return resp;
	}
	
	/*********** Request mapping for deleting book, which takes 1 RquestParameters *********/
	
	@RequestMapping(value = "/deleteBook", method = { RequestMethod.GET,
			RequestMethod.POST },headers="Accept=application/json")
	public @ResponseBody DeleteResponse deleteUser(@RequestParam("barcode") long id) {
		
		DeleteResponse resp=new DeleteResponse();
		int barcodeFlag=checkBarcode(id);
		if (barcodeFlag==0) {
			resp.setRespMessage("Barcode greater than 12 digits");
			resp.setStatusMessage("UNSUCCESSFUL");
			
		}
		
		 resp=bookService.deleteUser(id);
		return resp;
	}
	
	/***** barcode validation *****/
	
	int checkBarcode(long barcode){
		
		if(String.valueOf(barcode).length()>12){
			return 0;
		}
		return 1;
	}

}