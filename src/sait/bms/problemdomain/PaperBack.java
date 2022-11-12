package sait.bms.problemdomain;

import java.io.IOException;

/**
 * 
 * Paperback class is a subclass of Book class which contains additional
 * attributes author, year and genre. This subclass is an extension of Book
 * class which is also inherit super() from Book abstract class.
 *
 * @author Tam Nguyen
 * @author Ma Cubay
 * @author Lee Hok Yin
 * @version September 28, 2022
 * 
 */

public class PaperBack extends Book {
	private String author;
	private int year;
	private String genre;

	/**
	 * Argument constructor assigns values for ISBN, call number, available, total,
	 * title, author, year and genre
	 * 
	 * @param isbn    Paperback's ISBN
	 * @param callNum Paperback's call number
	 * @param avail   Paperback's available
	 * @param total   Paperback's total
	 * @param title   Paperback's title
	 * @param author  Paperback's author
	 * @param year    Paperback's year
	 * @param genre   Paperback's genre
	 * @throws IOException Thrown when the file could not be accessed.
	 */

	public PaperBack(long isbn, String callNum, int avail, int total, String title, String author, int year,
			String genre) throws IOException {
		super(isbn, callNum, avail, total, title);
		this.author = author;
		this.year = year;
		this.genre = genre;
	}

	/**
	 * Gets the author
	 * 
	 * @return the author
	 */

	public String getAuthor() {
		return author;
	}

	/**
	 * Gets the year
	 * 
	 * @return the year
	 */

	public int getYear() {
		return year;
	}

	/**
	 * Gets the genre
	 * 
	 * @return the genre
	 */

	public String getGenre() {
		return genre;
	}

	/**
	 * Prints the paperback book field
	 * 
	 * @return print the paperback book field
	 */

	public String printPaperBackBook() {
		if (genre.equals("A")) {
			genre = "Adventure";
		} else if (genre.equals("D")) {
			genre = "Drama";
		} else if (genre.equals("E")) {
			genre = "Education";
		} else if (genre.equals("C")) {
			genre = "Classic";
		} else if (genre.equals("F")) {
			genre = "Fantasy";
		} else if (genre.equals("S")) {
			genre = "Science Fiction";
		}

		return "\nISBN: " + "\t\t" + isbn + "\n" + "Call Number: " + "\t" + callNum + "\n" + "Available: " + "\t"
				+ avail + "\n" + "Total: " + "\t\t" + total + "\n" + "Title: " + "\t\t" + title + "\n" + "Author: "
				+ "\t" + author + "\n" + "Year: " + "\t\t" + year + "\n" + "Genre: " + "\t\t" + genre + "\n";
	}

	/**
	 * Override the methods of the superclass Book
	 * 
	 * @return a string representation of the Paperback.
	 */

	@Override
	public String toString() {
		return isbn + ";" + callNum + ";" + avail + ";" + total + ";" + title + ";" + author + ";" + year + ";" + genre;
	}

}
