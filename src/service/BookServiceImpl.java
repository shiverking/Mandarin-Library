package service;

import java.util.List;
import model.Book;
import model.Borrowrecord;
import util.PageBean;

public class BookServiceImpl extends BaseService<Book> implements BookService {

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		List<Book> books = this.getDao().findAll();
		return books;
	}

	public List<Book> getAllBooks(String cond) {
		// TODO Auto-generated method stub
		List<Book> books = this.getDao().findAll(cond);
		return books;
	}

	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		this.getDao().save(book);
	}

	public void mergeBook(Book book) {
		// TODO Auto-generated method stub
		this.getDao().merge(book);
	}
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		Book book = this.getDao().get(id);
		return book;
	}

	public Book getBookByBorrowrecord(Borrowrecord borrowrecord) {
		int id = borrowrecord.getBookID();
		return this.getBookById(id);
	}

	public List<Book> getBookByISBN(String cond) {
		// TODO Auto-generated method stub

		return this.getDao().findBySubString("ISBN", cond);

	}

	public List<Book> getBooksByBookName(String cond) {
		// TODO Auto-generated method stub

		return this.getDao().findBySubString("BookName", cond);

	}

	public void deleteBookById(int id) {
		// TODO Auto-generated method stub
		this.getDao().delete(id);
	}

	public List<Book> getBookByNameOrISBN(String cond) {
		// TODO Auto-generated method stub
		return this.getDao().findByTwoProperty("BookName", "ISBN", cond);
	}

	public PageBean<Book> getPageBean(String cond, Integer pageNum) {
		//TODO:·ÖÒ³ËÑË÷
		int current = 1;
		if (pageNum != null) {
			current=pageNum;
		}
		int totalRecords = this.getDao().findTotalNumbyTwoSubstring("ISBN", "BookName", cond);
		PageBean<Book> bookPageBean = new PageBean<Book>(totalRecords, current);
		bookPageBean.setDataList(this.getDao().findPageByTwoSubstring("ISBN", "BookName", cond,cond,
				bookPageBean.getStartIndex(), bookPageBean.getPageSize()));
		return bookPageBean;
	}

}
