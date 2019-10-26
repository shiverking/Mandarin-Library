package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	private List<Book> books;// ¿ÉÄÜ±»bookPageÈ¡´ú£¬½¨ÒéÉÙÓÃ£¬ÈçÐèÊ¹ÓÃÇë¸Ä×¢ÊÍ
	private List<Borrowrecord> borrowrecords;// ¿ÉÄÜ±»É¾³ý
	private List<CurrentRecord> currentRecords;// Ö¸Ô¤Ô¼Êé¼®µÄÐÅÏ¢
	private PageBean<Borrowrecord> borrowPage;// ÒÑ¹é»¹µÄÊé¼®ÐÅÏ¢
	private PageBean<Book> bookPage;
	private Integer pageNum;
	private ISBNgenerator iSBNgenerator;
	private String searchContent;
	private String categoryString;
	private Integer selectSearch;
	private Map<String, Integer> categoryMap;
	private Boolean	displayStyle=true;
	// ÒÔÏÂÊÇ¾ßÌåÊ¹ÓÃµÄ¹¦ÄÜº¯Êý

	// readerï¿½ï¿½ÒªÊ¹ï¿½ÃµÄºï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	public String searchBook() {
		// TODO:·ÖÒ³ËÑË÷
	
		if (selectSearch != null) {
			switch (selectSearch) {
			case 1:
				bookPage = this.getService().getPageBean(searchContent,categoryString, pageNum);
				break;
			case 2:
				bookPage = this.getService().getPageBeanbyISBN(searchContent,categoryString, pageNum);
				break;
			case 3:
				bookPage = this.getService().getPageBeanbyTitle(searchContent,categoryString, pageNum);
				break;
			case 4:
				bookPage = this.getService().getPageBeanbyAuthor(searchContent,categoryString, pageNum);
				break;
			default:
				bookPage = this.getService().getPageBean(searchContent,categoryString,pageNum);
			}
		} else {
			bookPage = this.getService().getPageBean(searchContent,categoryString, pageNum);
		}
		this.getCategory();
		return SUCCESS;
	}

	public String getCategory() {
		List<String> cStrings = this.getService().getCategory(searchContent, selectSearch);
		Map<String, Integer> tempMap = new HashMap<String, Integer>();
		for (Iterator iterator = cStrings.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			String[] tsStrings = string.split(",");
			for (int i = 0; i < tsStrings.length; i++) {
				if (tempMap.containsKey(tsStrings[i])) {
					tempMap.put(tsStrings[i],tempMap.get(tsStrings[i])+1);
				}else tempMap.put(tsStrings[i],1);
			}
		}
		categoryMap = tempMap;
		return SUCCESS;
	}

	public String getBooksbyBorrwrecords() {
		books = new ArrayList<Book>();
		for (Borrowrecord borrowrecord : borrowrecords) {
			books.add(this.getService().getBookByBorrowrecord(borrowrecord));
		}
		return SUCCESS;
	}

	public String getBooksbyborrowPage() {
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

	public String reserveBook() {
		this.book = this.getService().getBookById(book.getBookID());
		if (book.getIsBorrowed() != false) {
			return ERROR;
		} else {
			book.setIsBorrowed(true);
			this.getService().mergeBook(book);
			return SUCCESS;
		}
	}

//ÒÔÏÂÊÇgetºÍsetº¯Êý
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

	public Integer getSelectSearch() {
		return selectSearch;
	}

	public void setSelectSearch(Integer selectSearch) {
		this.selectSearch = selectSearch;
	}

	public Map<String, Integer> getCategoryMap() {
		return categoryMap;
	}

	public void setCategoryMap(Map<String, Integer> categoryMap) {
		this.categoryMap = categoryMap;
	}

	public String getCategoryString() {
		return categoryString;
	}

	public void setCategoryString(String categoryString) {
		this.categoryString = categoryString;
	}

	public Boolean getDisplayStyle() {
		return displayStyle;
	}

	public void setDisplayStyle(Boolean displayStyle) {
		this.displayStyle = displayStyle;
	}

}
