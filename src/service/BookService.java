package service;

import java.util.List;

import model.Book;
import model.Borrowrecord;

/**
* @author 
* @version 创建时间：2019年9月24日 上午2:14:15
* 
*/
public interface BookService {
	public List<Book> getAllBooks();
	public List<Book> getAllBooks(String cond);
	public void saveBook(Book book);
	public void mergeBook(Book book);
	
	public Book getBookById(int id);
	public Book getBookByBorrowrecord(Borrowrecord borrowrecord);
	public List<Book> getBooksByBookName(String cond);
	public void deleteBookById(int id);
}
