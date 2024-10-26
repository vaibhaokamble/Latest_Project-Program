package com.example.bookmanagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/book_management";
	private String jdbcUsername = "vaibhaovk";
	private String jdbcPassword = "vaibhao";

	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void addBook(Book book) {
		String sql = "INSERT INTO books (title, author, publisher, price) VALUES (?, ?, ?, ?)";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setString(3, book.getPublisher());
			preparedStatement.setDouble(4, book.getPrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		String sql = "SELECT * FROM books";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				String publisher = resultSet.getString("publisher");
				double price = resultSet.getDouble("price");
				books.add(new Book(id, title, author, publisher, price));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	public void updateBook(Book book) {
		String sql = "UPDATE books SET title = ?, author = ?, publisher = ?, price = ? WHERE id = ?";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setString(3, book.getPublisher());
			preparedStatement.setDouble(4, book.getPrice());
			preparedStatement.setInt(5, book.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBook(int id) {
		String sql = "DELETE FROM books WHERE id = ?";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
