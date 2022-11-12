package sait.bms.problemdomain;
import java.io.IOException;

/**
 * Book class is an abstract class which can instantiate isbn, callNum, avail, total, title.
 * @author Tam Nguyen 
 * @author Ma Cubay 
 * @author Lee Hok Yin
 * @version September 28, 2022
 */

public abstract class Book {

	public long isbn;
	public String callNum;
	public int avail;
	public int total;
	public String title;
	
	/**
	 * Book constructor assigns values for ISBN, call number, available, total and title
	 * 
	 * @param isbn  book's ISBN
	 * @param callNum  book's call number
	 * @param avail  book's availability
	 * @param total  book's total amount
	 * @param title  book's title
	 * @throws IOException  Thrown when the file could not be accessed.
	 */
	
	public Book(long isbn, String callNum, int avail, int total, String title) throws IOException {
		this.isbn = isbn;
		this.callNum = callNum;
		this.avail = avail;
		this.total = total;
		this.title = title;
			
	}

	// no-arg constructor 
	public Book() {
	}

	/** 
	 * Gets the ISBN.
	 * 
	 * @return the ISBN
	 */

	public long getIsbn() {
		return isbn;
	}

	/**
	 * Gets the call number
	 * 
	 * @return the call number
	 */

	public String getCallNum() {
		return callNum;
	}

	/**
	 * Gets the available
	 * 
	 * @return the available
	 */

	public int getAvail() {
		return avail;
	}

	/**
	 * Sets the available
	 * 
	 * @param avail the available to set
	 */
	
	public void setAvail(int avail) {
		this.avail = avail;
	}

	/**
	 * Gets the total
	 * 
	 * @return the total
	 */

	public int getTotal() {
		return total;
	}

	/**
	 * Gets the title
	 * 
	 * @return the title
	 */

	public String getTitle() {
		return title;
	}
	
}
