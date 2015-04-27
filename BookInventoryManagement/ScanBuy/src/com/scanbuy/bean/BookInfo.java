package com.scanbuy.bean;


public class BookInfo {

	protected Long barcode; 
	protected String nameOfBook;
	protected String authorName;
	protected Integer numOfPages;
	protected String read;

	/* getter and setter */
	public long getBarcode() {
		return barcode;
	}
	public void setBarcode(Long barcode) {
		this.barcode = barcode;
	}
	public String getNameOfBook() {
		return nameOfBook;
	}
	public void setNameOfBook(String nameOfBook) {
		this.nameOfBook = nameOfBook;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getNumOfPages() {
		return numOfPages;
	}
	public void setNumOfPages(Integer numOfPages) {
		this.numOfPages = numOfPages;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	
}
