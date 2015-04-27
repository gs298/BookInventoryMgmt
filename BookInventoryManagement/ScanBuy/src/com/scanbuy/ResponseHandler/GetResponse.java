package com.scanbuy.ResponseHandler;

import com.scanbuy.bean.BookInfo;
public class GetResponse {
	
	BookInfo book;
	String statusMessage;
	public BookInfo getBook() {
		return book;
	}
	public void setBook(BookInfo book) {
		this.book = book;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	
	
}
