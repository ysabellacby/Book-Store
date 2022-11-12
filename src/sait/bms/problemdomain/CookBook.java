package sait.bms.problemdomain;

import java.io.IOException;

/**
 * 
 * Cook Book class is a subclass of Book class which contains additional
 * attributes publisher and diet. This subclass is an extension of Book class
 * which is also inherit super() from Book abstract class.
 *
 * @author Tam Nguyen
 * @author Ma Cubay
 * @author Lee Hok Yin
 * @version September 28, 2022
 * 
 */

public class CookBook extends Book {

	private String publisher;
	private String diet;

	/**
	 * Argument constructor assigns values for ISBN, call number, available, total,
	 * title, publisher, diet
	 * 
	 * @param isbn      Cookbook's ISBN
	 * @param callNum   Cookbook's call number
	 * @param avail     Cookbook's available
	 * @param total     Cookbook's total
	 * @param title     Cookbook's title
	 * @param publisher Cookbook's publisher
	 * @param diet      Cookbook's diet
	 * @throws IOException Thrown when the file could not be accessed.
	 */

	public CookBook(long isbn, String callNum, int avail, int total, String title, String publisher, String diet)
			throws IOException {
		super(isbn, callNum, avail, total, title);
		this.publisher = publisher;
		this.diet = diet;
	}

	/**
	 * Gets the publisher
	 * 
	 * @return the publisher
	 */

	public String getPublisher() {
		return publisher;
	}

	/**
	 * Get the diet
	 * 
	 * @return the diet
	 */

	public String getDiet() {
		return diet;
	}

	/**
	 * print the cookbook fields
	 * 
	 * @return print cookbook fields
	 */

	public String printCookBook() {
		if (diet.equals("D")) {
			diet = "Diabetic";
		} else if (diet.equals("V")) {
			diet = "Vegetarian";
		} else if (diet.equals("G")) {
			diet = "Gluten-free";
		} else if (diet.equals("I")) {
			diet = "International";
		} else if (diet.equals("N")) {
			diet = "None";
		}
		return "\nISBN: " + "\t\t" + isbn + "\n" + "Call Number: " + "\t" + callNum + "\n" + "Available: " + "\t"
				+ avail + "\n" + "Total: " + "\t\t" + total + "\n" + "Title: " + "\t\t" + title + "\n" + "Publisher: "
				+ "\t" + publisher + "\n" + "Diet: " + "\t\t" + diet + "\n";
	}

	/**
	 * Override the methods of the superclass Book
	 * 
	 * @return a string representation of the Cookbook.
	 */

	@Override
	public String toString() {
		return isbn + ";" + callNum + ";" + avail + ";" + total + ";" + title + ";" + publisher + ";" + diet;
	}
	
}
