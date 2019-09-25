package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import model.Book;
import model.Borrowrecord;
import model.Reader;
import service.BookService;

public class BookAction extends BaseAction<Book, BookService> {
	private List<Book> books;
	private List<Book> books1;
	private List<Book> books2;
	private List<Borrowrecord> borrowrecords;
	private String searchContent;
	private List<String> results1;
	private List<String> results2;

	public String getBooksbyBorrwrecords() {
		books = new ArrayList<Book>();

		for (Borrowrecord borrowrecord : borrowrecords) {
			books.add(this.getService().getBookByBorrowrecord(borrowrecord));
		}
		this.books = books;
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

	public List<Book> getBooks1() {
		return books1;
	}

	public void setBooks1(List<Book> books1) {
		this.books1 = books1;
	}

	public List<Book> getBooks2() {
		return books2;
	}

	public void setBooks2(List<Book> books2) {
		this.books2 = books2;
	}

	public String search() {
		if (this.searchContent == null) {
			return NONE;
		} else

		{
			return "isbook";
		}
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public String searchBook() {
		books1 = this.getService().getBookByISBN(searchContent);
		books2 = this.getService().getBooksByBookName(searchContent);
		if (books2 == null)
			return "isisbn";
		else
			return "isname";
	}

	public String getResult1() {
		results1 = new ArrayList<String>();
		for (Book book : books1) {
			results1.add(book.getISBN());
		}
		return SUCCESS;
	}

	public String getResult2() {
		results2 = new ArrayList<String>();
		for (Book book : books2) {
			results2.add(book.getBookName());
		}
		return SUCCESS;
	}
}
