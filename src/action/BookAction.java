package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import model.Book;
import model.Borrowrecord;
import model.Reader;
import service.BookService;
import util.PageBean;

public class BookAction extends BaseAction<Book, BookService> {
	private List<Book> books;
	private List<Borrowrecord> borrowrecords;
	private PageBean<Borrowrecord> borrowPageBean;
	private String searchContent;

	public String searchBook() {
		books = new ArrayList<Book>();
		books = this.getService().getBookByNameOrISBN(searchContent);
		return SUCCESS;
	}

	public String getBooksbyBorrwrecords() {
		books = new ArrayList<Book>();
		for (Borrowrecord borrowrecord : borrowPageBean.getDataList()) {
			books.add(this.getService().getBookByBorrowrecord(borrowrecord));
		}
		return SUCCESS;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
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

	public PageBean<Borrowrecord> getBorrowPageBean() {
		return borrowPageBean;
	}

	public void setBorrowPageBean(PageBean<Borrowrecord> borrowPageBean) {
		this.borrowPageBean = borrowPageBean;
	}
	

}
