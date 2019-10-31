package action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

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
	private List<Book> books=new ArrayList<Book>();//
	private List<Borrowrecord> borrowrecords;// 
	private List<CurrentRecord> currentRecords;//
	private PageBean<Borrowrecord> borrowPage;// 
	private PageBean<Book> bookPage;
	private Integer pageNum;
	private ISBNgenerator iSBNgenerator;
	private String searchContent;
	private String FineValues;
	private String ReturnPeriods;

	//

	public String getFineValues() {
		return FineValues;
	}

	public void setFineValues(String fineValues) {
		FineValues = fineValues;
	}

	public String getReturnPeriods() {
		return ReturnPeriods;
	}

	public void setReturnPeriods(String returnPeriods) {
		ReturnPeriods = returnPeriods;
	}

	// 
	public String searchBook() {
		// TODO:
		bookPage = this.getService().getPageBean(searchContent, pageNum);
		return SUCCESS;
	}

	public String getBooksbyBorrwrecords() {
		books = new ArrayList<Book>();
		for (Borrowrecord borrowrecord : borrowrecords) {
			books.add(this.getService().getBookByBorrowrecord(borrowrecord));
		}
		return SUCCESS;
	}

	public String getBooksbycurrentRecords() {
		//TODO:
		books = new ArrayList<Book>();
		for (CurrentRecord currentRecord : currentRecords) {
			books.add(this.getService().getBookById(currentRecord.getBookID()));
		}
		return SUCCESS;
	}

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
		 List<Book> B= this.getService().getAllBooks();
		 Iterator<Book> BI=B.iterator();
		 if(BI.hasNext()) {
			 Book b=BI.next();
			 books.add(b);
		 }
		 while(BI.hasNext())
		 {
			 Book b=BI.next();
			 int length=books.size();
			 if(b.getISBN().equals(books.get(length-1).getISBN())==false)
			 {
				 books.add(b);
			 }
			 
		 }
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

	public List<CurrentRecord> getCurrentRecords() {
		return currentRecords;
	}

	public void setCurrentRecords(List<CurrentRecord> currentRecords) {
		this.currentRecords = currentRecords;
	}
	
	public String adminEditBook() {

		String i = this.getModel().getISBN();
		String f = this.FineValues;
		String rp =this.ReturnPeriods;
		if(f.isEmpty())
		{
			this.errorMessage="Please enter number";
			this.display();
			System.out.println(this.errorMessage);
			return INPUT;
		}
		if(rp.isEmpty())
		{
			this.errorMessage="Please enter number";
			this.display();
			System.out.println(this.errorMessage);
			return INPUT;
		}
		else 
		try {
		int f1 =Integer.parseInt(f);
		int rp1=Integer.parseInt(rp);
		if(f1>=0&rp1>=0)
		{
        List<Book> temBook = this.getService().getAllBooks();
        Iterator<Book> iBook = temBook.iterator();
        while(iBook.hasNext())
        {
        	Book b=iBook.next();
        	if((b.getISBN().equals(i))==true)
        	{
        		b.setFineValue(f1);
        		b.setReturnPeriod(rp1);
        		this.getService().mergeBook(b);
        	}
        }
		return this.display();
		}
		else
		{
			this.errorMessage="Please enter the correct number";
			this.display();
			System.out.println(this.errorMessage);
			return INPUT;
		}
		
		}catch(Exception e)
		{
			this.errorMessage="Please enter the correct number";
			this.display();
			System.out.println(this.errorMessage);
			return INPUT;
		}
	}
}