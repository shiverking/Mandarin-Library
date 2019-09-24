package action;

import java.util.ArrayList;
import java.util.List;

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

public void setBorrowrecords(List<Borrowrecord> borrowrecords) {
	this.borrowrecords=borrowrecords;
}
public List<Book> getBooks() {
	return books;
}

public void setBooks(List<Book> books) {
	this.books = books;
}

}
