package vaibhao.vk;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Book {
	private int id;
	private String name;
	private double price;

	public Book(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Book(" + "id=" + id + ", name='" + name + '\'' + ", price=" + price + ')';
	}
}

public class BookListExample {
	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();

		System.out.println("Original list:");
		for (Book book : books) {
			System.out.println(book);
		}

		books.sort(Comparator.comparingInt(Book::getId));
		System.out.println("\nSorted by ID:");
		for (Book book : books) {
			System.out.println(book);
		}

		books.sort(Comparator.comparingDouble(Book::getPrice));
		System.out.println("\nSorted by Price:");
		for (Book book : books) {
			System.out.println(book);
		}
	}
}