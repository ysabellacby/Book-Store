package sait.bms.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import sait.bms.problemdomain.Book;
import sait.bms.problemdomain.ChildrensBook;
import sait.bms.problemdomain.CookBook;
import sait.bms.problemdomain.PaperBack;
import sait.bms.problemdomain.Periodical;

/**
 * BookManager is to read and write the input and output from the user input.
 * and run the checkOut, find, display and save
 *
 * @author Tam Nguyen
 * @author Ma Cubay
 * @author Lee Hok Yin
 * @version September 28, 2022
 * 
 */

public class BookManager extends Book {

	public ArrayList<Book> books;
	public Scanner in;

	/**
	 * Load book and display menu
	 * 
	 * @throws IOException Thrown when the file could not be accessed.
	 */

	public BookManager() throws IOException {
		books = new ArrayList<>();
		loadBooks();
		in = new Scanner(System.in);
		displayMenu();
	}

	/**
	 * Load the book for correct book type
	 *
	 * @throws IOException Thrown when the file could not be accessed.
	 */

	public void loadBooks() throws IOException {
		books = new ArrayList<>();
		Scanner in = new Scanner(new File("res\\books.txt"));

		while (in.hasNext()) {
			String line = in.nextLine();
			String[] fields = line.split(";");

			long isbn = Long.parseLong(fields[0]);
			String callNum = fields[1];
			int avail = Integer.parseInt(fields[2]);
			int total = Integer.parseInt(fields[3]);
			String title = fields[4];

			int isbnLastNum = (int) (isbn % 10);
			Book books2 = null;

			// TODO: Create the if-else statement to check which kind of book
			if (isbnLastNum == 0 || isbnLastNum == 1) {
				books2 = new ChildrensBook(isbn, callNum, avail, total, title, fields[5], fields[6]);
			} else if (isbnLastNum == 2 || isbnLastNum == 3) {
				books2 = new CookBook(isbn, callNum, avail, total, title, fields[5], fields[6]);
			} else if (isbnLastNum >= 4 && isbnLastNum <= 7) {
				books2 = new PaperBack(isbn, callNum, avail, total, title, fields[5], Integer.parseInt(fields[6]),
						fields[7]);
			} else if (isbnLastNum == 8 || isbnLastNum == 9) {
				books2 = new Periodical(isbn, callNum, avail, total, title, fields[5]);
			}

			books.add(books2);
		}
		in.close();

	}

	/**
	 * Display the book function menu
	 * 
	 * @throws IOException Thrown when the file could not be accessed.
	 */

	public void displayMenu() throws IOException {
		int choice = 0;
		while (choice != 5) {
			System.out.println("Welcome in ABC Book Company: How May We Assist You?");
			System.out.println("1     Checkout Book");
			System.out.println("2     Find Books by Title");
			System.out.println("3     Display Books by Type");
			System.out.println("4     Produce Random Book List");
			System.out.println("5     Save & Exit");
			System.out.print("Enter option: ");
			choice = in.nextInt();

			if (choice == 1) {
				checkOut();
			} else if (choice == 2) {
				findBookByTitle();
			} else if (choice == 3) {
				findBookByType();
			} else if (choice == 4) {
				findRandomBook();
			} else if (choice == 5) {
				save();
			}
		}

	}

	/**
	 * Checkout book by enter ISBN and then print out the book fields
	 * 
	 * 
	 * @throws IOException Thrown when the file could not be accessed.
	 */

	public void checkOut() throws IOException {

		System.out.print("Enter ISBN number: ");
		long userIn = in.nextLong();
		for (int i = 0; i < books.size(); i++) {
			Book books2 = books.get(i);
			if (userIn == books2.getIsbn() && books2.getAvail() > 0) {
				avail = books2.getAvail();
				avail = avail - 1;
				books2.setAvail(avail);
				System.out.println("\nThe book \"" + books2.getTitle() + "\" has been checked out. ");
				System.out.println("It can be located using a call number: " + books2.getCallNum() + "\n");
			}
		}

	}

	/**
	 * Find book by using title of the book. and then print out the book fields
	 * 
	 * 
	 * @throws IOException Thrown when the file could not be accessed.
	 */

	public void findBookByTitle() throws IOException {
		System.out.print("Enter the title you search for: ");
		String userInTitle = in.next().toLowerCase();
		System.out.println("Matching Book: ");
		for (int i = 0; i < books.size(); i++) {
			Book books2 = books.get(i);
			String titleFromBook = books2.getTitle().toLowerCase();
			titleFromBook = titleFromBook.replaceAll("\\s", "");

			if (titleFromBook.contains(userInTitle)) {

				if (books2 instanceof ChildrensBook) {
					System.out.println(((ChildrensBook) books2).printChildrensBook());

				} else if (books2 instanceof CookBook) {
					System.out.println(((CookBook) books2).printCookBook());

				} else if (books2 instanceof PaperBack) {
					System.out.println(((PaperBack) books2).printPaperBackBook());

				} else if (books2 instanceof Periodical) {
					System.out.println(((Periodical) books2).printPeriodicalBook());

				} else {
					System.out.println("There is no book matching! Please try again!");
				}
			}
		}
	}

	/**
	 * Find book by using type of the book. and then print out the book fields
	 * 
	 * 
	 * @throws IOException Thrown when the file could not be accessed.
	 */

	public void findBookByType() throws IOException {
		System.out.println("#Type");
		System.out.println("1. Children's Books");
		System.out.println("2. Cookbooks");
		System.out.println("3. Paperbacks");
		System.out.println("4. Periodicals");
		System.out.print("Enter type of book: ");
		int type = in.nextInt();
		switch (type) {
		case 1: // ChilrensBook
			System.out.println("Enter format of book: ");
			String formatUser = in.next();

			for (Book bok : books) {
				if (bok instanceof ChildrensBook && formatUser.equals(((ChildrensBook) bok).getFormat())) {
					System.out.println(((ChildrensBook) bok).printChildrensBook());
				}
			}
			break;

		case 2: // CookBook
			System.out.println("Enter type of diet: ");
			String dietUser = in.next();

			for (Book bok : books) {
				if (bok instanceof CookBook && dietUser.equals(((CookBook) bok).getDiet())) {
					System.out.println(((CookBook) bok).printCookBook());
				}
			}
			break;

		case 3: // Paperback
			System.out.println("Enter type of genre: ");
			String genreUser = in.next();

			for (Book bok : books) {
				if (bok instanceof PaperBack && genreUser.equals(((PaperBack) bok).getGenre())) {
					System.out.println(((PaperBack) bok).printPaperBackBook());
				}
			}
			break;
		case 4: // Periodical Book
			System.out.print("Enter a frequency (D for Daily, W for Weekly, "
					+ "M for Monthly, B for Bi-monthly, or Q for Quarterly): ");
			String frequencyInput = in.next();

			for (Book bok : books) {
				if ((bok instanceof Periodical) && ((Periodical) bok).getFrequency().equals(frequencyInput)) {
					System.out.println(((Periodical) bok).printPeriodicalBook());
					;
				}
			}
			break;
		}
	}

	/**
	 * Find book by random. and then print out the random book and its fields
	 * 
	 * 
	 * @throws IOException Thrown when the file could not be accessed.
	 */

	public void findRandomBook() throws IOException {
		System.out.print("Enter number of books: ");
		int userNumBook = in.nextInt();
		Collections.shuffle(books);
		
		System.out.println("Random Book: ");
		for (int i = 0; i < userNumBook; i++) {
			Book books2 = books.get(i);
			if (books2 instanceof ChildrensBook) {
				System.out.println(((ChildrensBook) books2).printChildrensBook());

			} else if (books2 instanceof CookBook) {
				System.out.println(((CookBook) books2).printCookBook());

			} else if (books2 instanceof PaperBack) {
				System.out.println(((PaperBack) books2).printPaperBackBook());

			} else if (books2 instanceof Periodical) {
				System.out.println(((Periodical) books2).printPeriodicalBook());
			}
		}
	}

	/**
	 * Save the new data of book after checkOut.
	 * 
	 */

	public void save() {
		boolean flag = true;
		try {
			if (flag = true) {
				FileWriter writer = new FileWriter("res\\books.txt", false);
				for (Book entry : books) {
					writer.write(entry + "\n");
				}
				writer.close();
			} else {
				return;
			}
		} catch (IOException e) {
			System.out.println("The file could not be written to!");
		}
	}

}
