package sait.bms.application;
import java.io.IOException;

/**
 * The App program implements an application that
 * manage the books from ABC Book company, 
 * so the employees and patrons could do the checkout, find, and list books.
 * 
 * App Driver is the main method to run the program.
 *
 * @author Tam Nguyen
 * @author Ma Cubay
 * @author Lee Hok Yin
 * @version September 28, 2022
 * 
 */
public class AppDriver {

	public static void main(String[] args) throws IOException {
		new sait.bms.manager.BookManager();
}

}
