package model;
import java.util.Date;
public class Deleterecord {
	private int DeleterecordID;
	private Librarian librarian;
	private Date Date;
	private String ISBN;
	
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



	public Librarian getLibrarian() {
		return librarian;
	}

	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}



}
