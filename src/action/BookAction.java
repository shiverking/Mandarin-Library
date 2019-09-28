package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import model.Book;
import model.Borrowrecord;
import model.Reader;
import service.BookService;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import util.ISBNgenerator;

public class BookAction extends BaseAction<Book, BookService> {
	private static Book book;
	private List<Book> books;
	private List<Borrowrecord> borrowrecords;
	private ISBNgenerator iSBNgenerator;
	private String searchContent;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

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

	public String addBook() throws Exception {
		HttpServletRequest PriceRequest =  ServletActionContext.getRequest();
		HttpServletRequest NumRequest = ServletActionContext.getRequest();
		String BookName = this.getModel().getBookName();
		int Price = Integer.parseInt(PriceRequest.getParameter("Price"));
		String Location = this.getModel().getLocation();
		String Category = this.getModel().getCategory();
		int Number = Integer.parseInt(NumRequest.getParameter("Num"));
		this.getModel().setBookName(BookName);
		this.getModel().setPrice(Price);
		this.getModel().setLocation(Location);
		this.getModel().setReturnPeriod(30);
		this.getModel().setFineValue(1);
		this.getModel().setIsBorrowed(false);
		this.getModel().setCategory(Category);
		for (int i = 0; i < Number; i++) {
			this.getModel().setISBN(iSBNgenerator.generateISBN());
			this.getService().saveBook(this.getModel());
		}
		return SUCCESS;
	}
	public String addBookPage() {
		return SUCCESS;
	}
	public String display() {
		this.books = this.getService().getAllBooks();
		return SUCCESS;
	}
	public String deleteBook() {
		this.getService().deleteBookById(book.getBookID());
		return SUCCESS;
	}
	public String editBook() {
		this.book = this.getService().getBookById(book.getBookID());
		if(this.getModel().getBookName()!=null) {
			book.setBookName(this.getModel().getBookName());
		}
		if(this.getModel().getPrice()>0) {
			book.setPrice(this.getModel().getPrice());;
		}
		if(this.getModel().getLocation()!=null) {
			book.setLocation(this.getModel().getLocation());
		}
		book.setIsBorrowed(this.getModel().getIsBorrowed());
		if(this.getModel().getCategory()!=null) {
			book.setCategory(this.getModel().getCategory());
		}
		this.getService().mergeBook(book);
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
