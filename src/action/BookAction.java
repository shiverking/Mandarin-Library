package action;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import com.opensymphony.xwork2.ActionContext;
import model.Book;
import model.Reader;
import service.BookService;

public class BookAction {
	private List<Book> booktable = new ArrayList<Book>();
	private Reader temReader;
	private String searchContent;
	private List<Reader> readers;

	public String searchBook() {
		booktable = this.getService().getBooksByBookName(searchContent);
		return "success";
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
=======

import model.Book;
import model.Borrowrecord;
import service.BookService;

/**
* @author 
* @version 创建时间：2019年9月24日 上午2:12:32
* 
*/
public class BookAction extends BaseAction<Book, BookService>{
private List<Book> books=new ArrayList<Book>();
private List<Borrowrecord> borrowrecords;



public String getBooksbyBorrwrecords() {
	List<Book> books=new ArrayList<Book>();
	for (Borrowrecord borrowrecord:borrowrecords) {
		books.add(this.getService().getBookByBorrowrecord(borrowrecord));
	}
	this.books=books;
	return SUCCESS;
}

public List<Borrowrecord> getBorrowrecords() {
	return borrowrecords;
}


public void setBorrowrecords(List<Borrowrecord> borrowrecords) {
	this.borrowrecords=borrowrecords;
}
public List<Book> getBooks() {
	return books;
}

public void setBooks(List<Book> books) {
	this.books = books;
}
>>>>>>> LDH

}
