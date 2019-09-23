package model;
import java.util.Date;
public class Payrecord {
	private int PayrecordID;
	private Date Date;
	private String Type;
	private int Amount;
	private Librarian librarian;
	
	public Payrecord() {
		
	}
	public Payrecord(java.util.Date date, String type, int amount) {
		super();
		Date = date;
		Type = type;
		Amount = amount;
	}
	
	public int getPayrecordID() {
		return PayrecordID;
	}
	public void setPayrecordID(int payrecordID) {
		PayrecordID = payrecordID;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}

	public Librarian getLibrarian() {
		return librarian;
	}

	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}
	
}
