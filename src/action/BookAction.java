package action;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Borrowrecord;
import model.CurrentRecord;
import service.BookService;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import util.ISBNgenerator;
import util.PageBean;

public class BookAction extends BaseAction<Book, BookService> {
	private static Book book;
	private List<Book> books;
	private List<CurrentRecord> currentRecords;// Ö¸ÔÚ½èÊé¼®ºÍÔ¤Ô¼Êé¼®µÄÐÅÏ¢
	private PageBean<Borrowrecord> borrowPage;// ½èÔÄ¼ÇÂ¼ÐÅÏ¢
	private PageBean<Book> bookPage;
	private Integer pageNum;
	private ISBNgenerator iSBNgenerator;
	private String searchContent;

	// ï¿½ï¿½ï¿½ï¿½ï¿½Ç¾ï¿½ï¿½ï¿½Ê¹ï¿½ÃµÄ¹ï¿½ï¿½Üºï¿½ï¿½ï¿½

	// readerï¿½ï¿½ÒªÊ¹ï¿½ÃµÄºï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	public String searchBook() {
		// TODO:ï¿½ï¿½Ò³ï¿½ï¿½ï¿½ï¿½
		bookPage = this.getService().getPageBean(searchContent, pageNum);
		return SUCCESS;
	}

	public String getBooksbyBorrowPage() {
		books = new ArrayList<Book>();
		for (Borrowrecord borrowrecord : borrowPage.getDataList()) {
			books.add(this.getService().getBookByBorrowrecord(borrowrecord));
		}
		return SUCCESS;
	}

	public String getBooksbycurrentRecords() {
		// TODO:¿ÉÄÜ¸ÄÓÃpagabeanÊµÏÖ
		books = new ArrayList<Book>();
		for (CurrentRecord currentRecord : currentRecords) {
			books.add(this.getService().getBookById(currentRecord.getBookID()));
		}
		return SUCCESS;
	}
	// readerï¿½ï¿½ÒªÊ¹ï¿½ÃµÄºï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½

	public String addBook() throws Exception {
		HttpServletRequest PriceRequest = ServletActionContext.getRequest();
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
		if (this.getModel().getBookName() != null) {
			book.setBookName(this.getModel().getBookName());
		}
		if (this.getModel().getPrice() > 0) {
			book.setPrice(this.getModel().getPrice());
			;
		}
		if (this.getModel().getLocation() != null) {
			book.setLocation(this.getModel().getLocation());
		}
		book.setIsBorrowed(this.getModel().getIsBorrowed());
		if (this.getModel().getCategory() != null) {
			book.setCategory(this.getModel().getCategory());
		}
		this.getService().mergeBook(book);
		return SUCCESS;
	}

//ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½getï¿½ï¿½setï¿½ï¿½ï¿½ï¿½
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public PageBean<Borrowrecord> getBorrowPage() {
		return borrowPage;
	}

	public void setBorrowPage(PageBean<Borrowrecord> borrowPage) {
		this.borrowPage = borrowPage;
	}

	public PageBean<Book> getBookPage() {
		return bookPage;
	}

	public void setBookPage(PageBean<Book> bookPage) {
		this.bookPage = bookPage;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public List<CurrentRecord> getCurrentRecords() {
		return currentRecords;
	}

	public void setCurrentRecords(List<CurrentRecord> currentRecords) {
		this.currentRecords = currentRecords;
	}
	
//adminä¿®æ”¹é€¾æœŸç½šé‡‘å’Œå½’è¿˜æœŸé™
	public String adminEditBook() {
		this.book = this.getService().getBookById(book.getBookID());
		if (this.getModel().getReturnPeriod() > 0) {
			book.setReturnPeriod(this.getModel().getReturnPeriod());
		}
		if (this.getModel().getFineValue() > 0) {
			book.setFineValue(this.getModel().getFineValue());
			;
		}
		this.getService().mergeBook(book);
		return SUCCESS;
	}

}
