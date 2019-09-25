package action;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Borrowrecord;
import service.BookService;

/**
 * @author
 * @version ����ʱ�䣺2019��9��24�� ����2:12:32
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
		this.books = books;
		return SUCCESS;
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
