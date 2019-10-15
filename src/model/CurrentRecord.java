package model;

import java.util.Date;

/**
* @author 
* @version ����ʱ�䣺2019��10��5�� ����6:42:40
* 
*/

/**
 * @author MX
 *
 */
public class CurrentRecord {
	private int CurrentRecordID;
	private int ReaderID;
	private int BookID;
	private Date BorrowingDate;

	public CurrentRecord() {
		CurrentRecordID =1;
		BorrowingDate = new Date();
	}

	public CurrentRecord(int readerID, int bookID) {
		ReaderID = readerID;
		BookID = bookID;
		BorrowingDate = new Date();
	}

	public int getCurrentRecordID() {
		return CurrentRecordID;
	}

	public void setCurrentRecordID(int currentRecordID) {
		CurrentRecordID = currentRecordID;
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

}
