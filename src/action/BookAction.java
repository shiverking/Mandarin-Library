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
	private List<Borrowrecord> borrowrecords;
	private String searchContent;


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

	

	public String search() {
		if (searchContent.isEmpty()) {
			return NONE;
		} else

		{
			return SUCCESS;
		}
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public String searchBook() {
		
		books = this.getService().getBookByNameOrISBN(searchContent);

		return SUCCESS;
	}

	
}
