package com.scanbuy.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.scanbuy.bean.BookInfo;
import com.scanbuy.utility.DBUtility;

public class BookService {

	private Connection connection;

	public BookService() {
		connection = DBUtility.getConnection();
	}

	public String addBook(BookInfo book) {
		try {

			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Book(id,name,author,page,rd) values (?,?, ?, ? ,?)");

			preparedStatement.setInt(1, book.getBarcode());
			preparedStatement.setString(2, book.getNameOfBook());
			preparedStatement.setString(3, book.getAuthorName());
			preparedStatement.setInt(4, book.getNumOfPages());
			preparedStatement.setString(5, book.getRead());
			preparedStatement.executeUpdate();
			
			return("Successfully Entered");
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("The exception is :"+e.getErrorCode());
			return ("Unsuccessful");
		}
		
		
	}

}

