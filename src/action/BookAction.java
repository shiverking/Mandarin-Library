package action;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Borrowrecord;
import service.BookService;

/**
 * @author
 * @version 锟斤拷锟斤拷时锟戒：2019锟斤拷9锟斤拷24锟斤拷 锟斤拷锟斤拷2:12:32
 * 
 */
public class BookAction extends BaseAction<Book, BookService> {
	private List<Book> books;
	private List<Borrowrecord> borrowrecords;

	public String getBooksbyBorrwrecords() {
		books = new ArrayList<Book>();

		for (Borrowrecord borrowrecord : borrowrecords) {
			books.add(this.getService().getBookByBorrowrecord(borrowrecord));
		}
		return SUCCESS;
}

	public List<Borrowrecord> getBorrowrecords() {
		return borrowrecords;
	}

	public void setBorrowrecords(List<Borrowrecord> borrowrecords) {
		this.borrowrecords = borrowrecords;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
