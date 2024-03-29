package service;

import java.util.List;
import model.Book;
import model.Borrowrecord;
import util.PageBean;

public class BookServiceImpl extends BaseService<Book> implements BookService {

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		List<Book> books = this.getDao().findAll();
		return books;
	}

	@Override
	public List<Book> getAllBooks(String cond) {
		// TODO Auto-generated method stub
		List<Book> books = this.getDao().findAll(cond);
		return books;
	}

	@Override
	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		this.getDao().save(book);
	}

	@Override
	public void mergeBook(Book book) {
		// TODO Auto-generated method stub
		this.getDao().merge(book);
	}
	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		Book book = this.getDao().get(id);
		return book;
	}

	@Override
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

	@Override
	public void deleteBookById(int id) {
		// TODO Auto-generated method stub
		this.getDao().delete(id);
	}

	@Override
	public List<Book> getBookByNameOrISBN(String cond) {
		// TODO Auto-generated method stub
		return this.getDao().findByTwoProperty("BookName", "ISBN", cond);
	}

	@Override
	public PageBean<Book> getPageBean(String cond, Integer pageNum) {
		//TODO:��ҳ����
		int current = 1;
		if (pageNum != null) {
			current=pageNum;
		}
		int totalRecords = this.getDao().findTotalNumbyTwoSubstring("ISBN", "BookName", cond);
		PageBean<Book> bookPageBean = new PageBean<Book>(totalRecords, current);
		bookPageBean.setDataList(this.getDao().findPageByTwoProperty("ISBN", "BookName", cond,
				bookPageBean.getStartIndex(), bookPageBean.getPageSize()));
		return bookPageBean;
	}

}
