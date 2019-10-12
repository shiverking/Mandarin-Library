package model;

public class Book {
	private int BookID;
	private String BookName;
	private String ISBN;
	private int Price;
	private String Location;
	private int ReturnPeriod;
	private int FineValue;
	private boolean isBorrowed;
	private String category;
	public Book() {
		ReturnPeriod = 30;
		FineValue = 1;
		isBorrowed = false;
	}
	public Book(int bookID, String bookName, String iSBN, int price, String location,String category
			) {
		//super();
		BookID = bookID;
		BookName = bookName;
		ISBN = iSBN;
		Price = price;
		Location = location;
		ReturnPeriod = 30;
		FineValue = 1;
		isBorrowed = false; //≥ı º◊¥Ã¨…Ë÷√Œ™Œ¥ΩË‘ƒ
		this.category=category;
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
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public int getReturnPeriod() {
		return ReturnPeriod;
	}
	public void setReturnPeriod(int returnPeriod) {
		ReturnPeriod = returnPeriod;
	}
	public int getFineValue() {
		return FineValue;
	}
	public void setFineValue(int fineValue) {
		FineValue = fineValue;
	}
	public boolean isBorrowed() {
		return isBorrowed;
	}
	public boolean getIsBorrowed() {
		return isBorrowed;
	}
	public void setIsBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
