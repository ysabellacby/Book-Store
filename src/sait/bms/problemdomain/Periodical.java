package sait.bms.problemdomain;

import java.io.IOException;

/**
 * 
 * Periodical class is a subclass of Book class which contains additional
 * attributes frequency. This subclass is an extension of Book class which is
 * also inherit super() from Book abstract class.
 *
 * @author Tam Nguyen
 * @author Ma Cubay
 * @author Lee Hok Yin
 * @version September 28, 2022
 * 
 */

public class Periodical extends Book {
	private String frequency;

	/**
	 * Argument constructor assigns values for ISBN, call number, available, total,
	 * title, frequency
	 * 
	 * @param isbn      Periodical's ISBN
	 * @param callNum   Periodical's call number
	 * @param avail     Periodical's available
	 * @param total     Periodical's total
	 * @param title     Periodical's title
	 * @param frequency Periodical's frequency
	 * @throws IOException Thrown when the file could not be accessed.
	 */

	public Periodical(long isbn, String callNum, int avail, int total, String title, String frequency) throws IOException {
		super(isbn, callNum, avail, total, title);
		this.frequency = frequency;
	}

	/**
	 * Gets the frequency
	 * 
	 * @return the frequency
	 */

	public String getFrequency() {
		return frequency;
	}

	/**
	 * Prints the periodical book field
	 * 
	 * @return print the periodical book field
	 */

	public String printPeriodicalBook() {
		if (frequency.equals("D")) {
			frequency = "Daily";
		} else if (frequency.equals("W")) {
			frequency = "Weekly";
		} else if (frequency.equals("M")) {
			frequency = "Monthly";
		} else if (frequency.equals("B")) {
			frequency = "Bi-monthly";
		} else if (frequency.equals("Q")) {
			frequency = "Quarterly";
		}
		return "\nISBN: " + "\t\t" + isbn + "\n" + "Call Number: " + "\t" + callNum + "\n" + "Available: " + "\t"
				+ avail + "\n" + "Total: " + "\t\t" + total + "\n" + "Title: " + "\t\t" + title + "\n" + "Frequency: "
				+ "\t" + frequency + "\n";
	}

	/**
	 * Override the methods of the superclass Book
	 * 
	 * @return a string representation of the Periodical.
	 */

	@Override
	public String toString() {

		return isbn + ";" + callNum + ";" + avail + ";" + total + ";" + title + ";" + frequency;
	}

}
