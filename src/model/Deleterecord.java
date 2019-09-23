package model;
import java.util.Date;
public class Deleterecord {
	private int LibrationID;
	private Date Date;
	private int BookID;
	private String BookName;
	public Deleterecord() {
		
	}
	
	public Deleterecord(int librationID, java.util.Date date, int bookID, String bookName) {
		//super();
		LibrationID = librationID;
		Date = date;
		BookID = bookID;
		BookName = bookName;
	}
	public int getLibrationID() {
		return LibrationID;
	}
	public void setLibrationID(int librationID) {
		LibrationID = librationID;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
}
