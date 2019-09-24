package action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Book;
import model.Borrowrecord;
import model.Reader;
import service.BorrowrecordService;

/**
 * @author
 * @version 创建时间：2019年9月24日 上午2:12:54
 * 
 */
public class BorrowrecordAction extends BaseAction<Borrowrecord, BorrowrecordService> {
	private List<Borrowrecord> borrowrecords ;
	private Reader tempReader;
	private List<Book> books;
	private List<String> booknameList;

	public String getBorrowrecordByReader(Reader reader) {
		
		borrowrecords=this.getService().getBorrowrecordsbyReader(reader);
		return SUCCESS;
	}
	public String getAllBorrowrecord() {
		
		this.borrowrecords = this.getService().getAllBorrowrecords();

		return SUCCESS;
	}
	public String getRecordBookName() {
		booknameList = new ArrayList<String>();
		for (Book book : books) {
			booknameList.add(book.getBookName());
		}
		return SUCCESS;
	}

	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public List<String> getBooknameList() {
		return booknameList;
	}

	public void setBooknameList(List<String> booknameList) {
		this.booknameList = booknameList;
	}

	public List<Borrowrecord> getBorrowrecords() {
		return borrowrecords;
	}

	public void setBorrowrecords(List<Borrowrecord> borrowrecords) {
		this.borrowrecords = borrowrecords;
	}

	public Reader getTempReader() {
		return tempReader;
	}

	public void setTempReader(Reader tempReader) {
		this.tempReader = tempReader;
	}

}
