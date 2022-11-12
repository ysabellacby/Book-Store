package sait.bms.problemdomain;

import java.io.IOException;

/**
 * Children Book class is a subclass of Book class which contains additional attributes author and format. 
 * This subclass is an extension of Book class which is also inherit super() from Book abstract class. 
 * @author Tam Nguyen
 * @author Ma Cubay
 * @author Lee Hok Yin
 * @version September 28, 2022
 * 
 */

public class ChildrensBook extends Book {
	private String author;
	private String format;
	
	/**
	 * Argument constructor assigns values for ISBN, call number, available, total, title, author and format
	 * 
	 * @param isbn  Children book's ISBN
	 * @param callNum  Children book's call number 
	 * @param avail  Children book's available
	 * @param total  Children book's total 
	 * @param title  Children book's title
	 * @param author  Children book's author
	 * @param format  Children book's format
	 * @throws IOException Thrown when the file could not be accessed.
	 */
	
	public ChildrensBook(long isbn, String callNum, int avail, int total, String title, String author, String format) throws IOException {
		super(isbn, callNum, avail, total, title);
		this.author = author;
		this.format = format;
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
	 * Gets the format
	 * 
	 * @return the format 
	 */
	
	public String getFormat() {
		return format;
	}

	/**
	 * print the children's book fields
	 * 
	 * @return children's book fields
	 */
	
	public String printChildrensBook() {
		if (format.equals("P")) {
			format = "Picture Book";
		} else if (format.equals("E")) {
			format = "Early Reader";
		} else if (format.equals("C")) {
		format = "Chapter";
		}
		return "\nISBN: " + "\t\t" + isbn + "\n" + 
		"Call Number: " + "\t" + callNum + "\n" + 
		"Available: " + "\t" + avail + "\n" + 
		"Total: " + "\t\t" + total + "\n" + 
		"Title: " + "\t\t" + title + "\n" + 
		"Author: " + "\t" + author + "\n" + 
		"Format: " + "\t" + format + "\n";
	
	}
	
	/**
	 * Override the methods of the superclass Book
	 * 
	 * @return  a string representation of the Childrensbook.
	 */

	@Override
	public String toString() {
		return isbn + ";" + callNum + ";" + avail + ";" + total + ";" + title + ";" + author + ";" + format;
	}
}

	


