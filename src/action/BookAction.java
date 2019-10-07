package action;

import java.util.ArrayList;
import java.util.List;





import model.Book;
import model.Borrowrecord;

import service.BookService;
import util.PageBean;

public class BookAction extends BaseAction<Book, BookService> {
	private List<Book> books;
	private List<Borrowrecord> borrowrecords;
	private PageBean<Borrowrecord> borrowPage;
	private PageBean<Book> bookPage;
	private Integer pageNum;
	private String searchContent;

	public String searchBook() {
		//TODO:·ÖÒ³ËÑË÷
	
		bookPage= this.getService().getPageBean(searchContent,pageNum);
		
		return SUCCESS;
	}

	public String getBooksbyBorrwrecords() {
		books = new ArrayList<Book>();
		for (Borrowrecord borrowrecord : borrowPage.getDataList()) {
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

	


	

}
