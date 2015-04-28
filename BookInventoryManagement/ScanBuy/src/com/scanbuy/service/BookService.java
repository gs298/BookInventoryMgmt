package com.scanbuy.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.scanbuy.bean.BookInfo;
import com.scanbuy.ResponseHandler.AddResponse;
import com.scanbuy.ResponseHandler.DeleteResponse;
import com.scanbuy.ResponseHandler.GetResponse;
import com.scanbuy.utility.DBUtility;

public class BookService {

	private Connection connection;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	public BookService() {
		connection = DBUtility.getConnection();
	}

	public AddResponse addBook(BookInfo book) {
		AddResponse resp = new AddResponse();
		try {

			preparedStatement = connection
					.prepareStatement("insert into Book(id,name,author,page,rd) values (?,?, ?, ? ,?)");

			preparedStatement.setLong(1, book.getBarcode());
			preparedStatement.setString(2, book.getNameOfBook());
			preparedStatement.setString(3, book.getAuthorName());
			preparedStatement.setInt(4, book.getNumOfPages());
			preparedStatement.setString(5, book.getRead());
			preparedStatement.executeUpdate();

			resp.setRespMessage("Successfully Added");
			resp.setStatusMessage("SUCCESS");
			return resp;

		} catch (SQLException e) {
			resp.setStatusMessage("UNSUCCESSFUL");
			resp.setRespMessage(e.getMessage());
			resp.setErrCode("" + e.getErrorCode());
			return resp;
		}
	}

	public GetResponse getBookInfo(long barcode) {
		BookInfo book = new BookInfo();
		GetResponse resp = new GetResponse();
		int count;

		try {

			count = ifExists(barcode);

			if (count != 0) {
				preparedStatement = connection
						.prepareStatement("select * from Book where id=?");
				preparedStatement.setLong(1, barcode);
				rs = preparedStatement.executeQuery();

				if (rs.next()) {
					book.setBarcode(rs.getLong("id"));
					book.setNameOfBook(rs.getString("name"));
					book.setAuthorName(rs.getString("author"));
					book.setNumOfPages(rs.getInt("page"));
					book.setRead(rs.getString("rd"));
				}
				resp.setBook(book);
				resp.setStatusMessage("Record Exists");
				resp.setStatusMessage("SUCCESS");

			}

			else {

				resp.setRespMessage("Record with barcode:" + barcode + ""
						+ " don't exists");
				resp.setStatusMessage("UNSUCCESS");

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return resp;

	}

	public DeleteResponse deleteUser(long barcode) {
		DeleteResponse resp = new DeleteResponse();
		try {

			int count = ifExists(barcode);

			if (count != 0) {
				preparedStatement = connection
						.prepareStatement("delete from Book where id=?");
				preparedStatement.setLong(1, barcode);
				preparedStatement.executeUpdate();

				resp.setStatusMessage("Record Exists");
				resp.setStatusMessage("SUCCESS");
			}

			else {
				resp.setRespMessage("Record with barcode:" + barcode + ""
						+ " don't exists");
				resp.setStatusMessage("UNSUCCESS");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return resp;
	}

	public int ifExists(long barcode) {

		int resCount = 0;
		try {
			preparedStatement = connection
					.prepareStatement("select count(*) from Book where id=?");
			preparedStatement.setLong(1, barcode);
			rs = preparedStatement.executeQuery();

			if (rs.next()) {
				return resCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resCount;
	}

}
