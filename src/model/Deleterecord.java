package model;
import java.util.Date;
public class Deleterecord {
	private int DeleterecordID;
	private Librarian librarian;
	private Date Date;
	private Book book;
	public Deleterecord() {
		
	}
	
	public Deleterecord(Date date) {
		super();
		Date = date;
	}
	
	public int getDeleterecordID() {
		return DeleterecordID;
	}

	public void setDeleterecordID(int deleterecordID) {
		DeleterecordID = deleterecordID;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Librarian getLibrarian() {
		return librarian;
	}

	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}
}
