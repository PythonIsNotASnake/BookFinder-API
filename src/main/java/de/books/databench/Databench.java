package de.books.databench;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

@Repository
public class Databench {

	Statement stmt;
	ResultSet rs;
	Connection con;

	public Databench() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			// String url = "jdbc:mysql://192.168.178.40:3306/books";
			String url = "jdbc:mysql://192.168.178.57:3306/books";
			//String url = "jdbc:mysql://localhost:3306/books";
			con = DriverManager.getConnection(url, "bernd", "123456");
			stmt = con.createStatement();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Add a new book into the database
	 *
	 * @param isbn
	 * @param title
	 * @param autor
	 * @param reihe
	 * @param place
	 * @param release
	 * @return
	 */
	public boolean addEntry(String isbn, String title, String autor, String reihe, String place, String release) {
		try {
			stmt.executeUpdate("INSERT INTO booklist VALUES ('" + isbn + "', '" + title + "', '" + autor + "', '"
					+ reihe + "', '" + place + "', '" + release + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Delete a book from the database
	 *
	 * @param isbn
	 * @return
	 */
	public boolean deleteEntry(String isbn) {
		try {
			stmt.executeUpdate("DELETE FROM booklist WHERE ISBN = '" + isbn + "' ");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Update the ISBN of a book
	 *
	 * @param isbn
	 * @param newState
	 * @return
	 */
	public boolean updateISBN(String isbn, String newState) {
		try {
			stmt.executeUpdate("UPDATE booklist SET ISBN = '" + newState + "' WHERE ISBN='" + isbn + "' ");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Update the title of a book
	 *
	 * @param isbn
	 * @param newState
	 * @return
	 */
	public boolean updateTitle(String isbn, String newState) {
		try {
			stmt.executeUpdate("UPDATE booklist SET Titel = '" + newState + "' WHERE ISBN='" + isbn + "' ");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Update the autor of a book
	 *
	 * @param isbn
	 * @param newState
	 * @return
	 */
	public boolean updateAutor(String isbn, String newState) {
		try {
			stmt.executeUpdate("UPDATE booklist SET Autor = '" + newState + "' WHERE ISBN='" + isbn + "' ");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Update the 'Reihe' of a book
	 *
	 * @param isbn
	 * @param newState
	 * @return
	 */
	public boolean updateReihe(String isbn, String newState) {
		try {
			stmt.executeUpdate("UPDATE booklist SET Reihe = '" + newState + "' WHERE ISBN='" + isbn + "' ");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Update the place where the book is actually
	 *
	 * @param isbn
	 * @param newState
	 * @return
	 */
	public boolean updatePlace(String isbn, String newState) {
		try {
			stmt.executeUpdate("UPDATE booklist SET Lagerort = '" + newState + "' WHERE ISBN='" + isbn + "' ");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Update the release year of a book
	 *
	 * @param isbn
	 * @param newState
	 * @return
	 */
	public boolean updateRelease(String isbn, String newState) {
		try {
			stmt.executeUpdate("UPDATE booklist SET Erscheinungsjahr = '" + newState + "' WHERE ISBN='" + isbn + "' ");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Make a list of all books in the database
	 *
	 * @return
	 */
	public Books getAllEntries() {
		Books books = new Books();
		// List<String> books = new LinkedList<>();
		try {
			rs = stmt.executeQuery("SELECT ISBN, Titel, Autor, Reihe, Lagerort, Erscheinungsjahr FROM booklist");
			while (rs.next()) {
				String isbn = rs.getString("ISBN");
				String titel = rs.getString("Titel");
				String autor = rs.getString("Autor");
				String reihe = rs.getString("Reihe");
				String place = rs.getString("Lagerort");
				String release = rs.getString("Erscheinungsjahr");

				Book book = new Book(isbn, titel, autor, reihe, place, release);
				books.getBookList().add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	/**
	 * Searching in the database
	 *
	 * @param search
	 * @return
	 */
	public Books search(String search) {
		search.toLowerCase();
		Books books = new Books();
		// List<String> books = new LinkedList<>();
		try {
			rs = stmt.executeQuery("SELECT ISBN, Titel, Autor, Reihe, Lagerort, Erscheinungsjahr FROM booklist");
			while (rs.next()) {
				String isbn = rs.getString("ISBN");
				String titel = rs.getString("Titel");
				String autor = rs.getString("Autor");
				String reihe = rs.getString("Reihe");
				String place = rs.getString("Lagerort");
				String release = rs.getString("Erscheinungsjahr");
				// String book = isbn + " " + titel + " " + autor + " " + reihe + " " + place +
				// " " + release;

				String isbnLow = isbn;
				String titelLow = titel;
				String autorLow = autor;
				String reiheLow = reihe;
				String placeLow = place;
				String releaseLow = release;

				Book book = new Book();

				if (isbnLow.toLowerCase().contains(search)) {
					book.setIsbn(isbn);
					book.setTitle(titel);
					book.setAutor(autor);
					book.setReihe(reihe);
					book.setPlace(place);
					book.setRelease(release);

					books.getBookList().add(book);
					continue;
				} else if (titelLow.toLowerCase().contains(search)) {
					book.setIsbn(isbn);
					book.setTitle(titel);
					book.setAutor(autor);
					book.setReihe(reihe);
					book.setPlace(place);
					book.setRelease(release);

					books.getBookList().add(book);
					continue;
				} else if (autorLow.toLowerCase().contains(search)) {
					book.setIsbn(isbn);
					book.setTitle(titel);
					book.setAutor(autor);
					book.setReihe(reihe);
					book.setPlace(place);
					book.setRelease(release);

					books.getBookList().add(book);
					continue;
				} else if (reiheLow.toLowerCase().contains(search)) {
					book.setIsbn(isbn);
					book.setTitle(titel);
					book.setAutor(autor);
					book.setReihe(reihe);
					book.setPlace(place);
					book.setRelease(release);

					books.getBookList().add(book);
					continue;
				} else if (placeLow.toLowerCase().contains(search)) {
					book.setIsbn(isbn);
					book.setTitle(titel);
					book.setAutor(autor);
					book.setReihe(reihe);
					book.setPlace(place);
					book.setRelease(release);

					books.getBookList().add(book);
					continue;
				} else if (releaseLow.toLowerCase().contains(search)) {
					book.setIsbn(isbn);
					book.setTitle(titel);
					book.setAutor(autor);
					book.setReihe(reihe);
					book.setPlace(place);
					book.setRelease(release);

					books.getBookList().add(book);
					continue;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	/**
	 * Close the connection to the database
	 */
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}

}
