package model;

public class Book {

	private int BookID;
	private String BookName;
	private String ISBN;
	private String Price;
	private String Location;
	private int ReturnPeriod;
	private int FineValue;
	private boolean isBorrowed;
	private String category;
	private String Author;
	private String Introduction;
	public Book(int bookID, String bookName, String iSBN, String price, String location, int returnPeriod,
			int fineValue, boolean isBorrowed, String category, String author, String introduction) {
		super();
		BookID = bookID;
		BookName = bookName;
		ISBN = iSBN;
		Price = price;
		Location = location;
		ReturnPeriod = returnPeriod;
		FineValue = fineValue;
		this.isBorrowed = isBorrowed;
		this.category = category;
		Author = author;
		Introduction = introduction;
	}
	public Book() {
		ReturnPeriod = 30;
		FineValue = 1;
		isBorrowed = false;
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

	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
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
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getIntroduction() {
		return Introduction;
	}
	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}
	
}
