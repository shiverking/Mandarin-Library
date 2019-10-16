package model;

import java.util.Date;

public class Borrowrecord {
	private int RecordID;
	private int ReaderID;
	private int BookID;
	private Date BorrowingDate;
	private Date ReturnDate;
	private Boolean isReturn;
	private Boolean isPayfine;
	private Integer Fine;
	
	public Borrowrecord() {
		
	}
	public Borrowrecord(int recordID, int readerID, int bookID, Date borrowingDate, Date returnDate) {
		//super();
		RecordID = recordID;
		ReaderID = readerID;
		BookID = bookID;
		BorrowingDate = borrowingDate;
		ReturnDate = returnDate;
		this.isReturn = false;//初始状态设置为未归还
		this.isPayfine = false;//初始状态设置为未缴纳罚款
		Fine = null;//初始罚款为零
	}
	public int getRecordID() {
		return RecordID;
	}
	public void setRecordID(int recordID) {
		RecordID = recordID;
	}
	public int getReaderID() {
		return ReaderID;
	}
	public void setReaderID(int readerID) {
		ReaderID = readerID;
	}
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	public Date getBorrowingDate() {
		return BorrowingDate;
	}
	public void setBorrowingDate(Date borrowingDate) {
		BorrowingDate = borrowingDate;
	}
	public Date getReturnDate() {
		return ReturnDate;
	}
	public void setReturnDate(Date returnDate) {
		ReturnDate = returnDate;
	}
	public Boolean isReturn() {
		return isReturn;
	}
	public Boolean getIsReturn() {
		return isReturn;
	}
	public void setIsReturn(Boolean isReturn) {
		this.isReturn = isReturn;
	}
	public Boolean isPayfine() {
		return isPayfine;
	}
	public Boolean getIsPayfine() {
		return isPayfine;
	}
	public void setIsPayfine(Boolean isPayfine) {
		this.isPayfine = isPayfine;
	}
	public Integer getFine() {
		return Fine;
	}
	public void setFine(Integer fine) {
		Fine = fine;
	}
	
}	
