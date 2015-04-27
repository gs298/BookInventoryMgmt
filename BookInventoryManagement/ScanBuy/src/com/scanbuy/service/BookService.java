package com.scanbuy.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.scanbuy.bean.BookInfo;
import com.scanbuy.addResponseHandler.AddResponse;
import com.scanbuy.utility.DBUtility;

public class BookService {

	private Connection connection;

	public BookService() {
		connection = DBUtility.getConnection();
	}

	public AddResponse addBook(BookInfo book) {
		AddResponse resp= new AddResponse();
		try {

			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Book(id,name,author,page,rd) values (?,?, ?, ? ,?)");

			preparedStatement.setLong(1, book.getBarcode());
			preparedStatement.setString(2, book.getNameOfBook());
			preparedStatement.setString(3, book.getAuthorName());
			preparedStatement.setInt(4, book.getNumOfPages());
			preparedStatement.setString(5, book.getRead());
			preparedStatement.executeUpdate();
			
			resp.setRespMessage("Successfully Added");
			
			return resp;
			
			

		} catch (SQLException e) {
			resp.setRespMessage("Can't Add \t"+ e.getMessage());
			resp.seterrCode(""+e.getErrorCode());
			return resp;
		}
		catch (Exception e) {
			resp.setRespMessage("Can't Add \t"+ e.getMessage());
			resp.seterrCode(""+e.getMessage());
			return resp;
		}
		
	}

}

