package service;

import java.util.List;
import model.Book;
import model.Borrowrecord;
import util.PageBean;

public class BookServiceImpl extends BaseService<Book> implements BookService {

<<<<<<< HEAD
=======
	@Override
>>>>>>> master
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		List<Book> books = this.getDao().findAll();
		return books;
	}

<<<<<<< HEAD
=======
	@Override
>>>>>>> master
	public List<Book> getAllBooks(String cond) {
		// TODO Auto-generated method stub
		List<Book> books = this.getDao().findAll(cond);
		return books;
	}

<<<<<<< HEAD
=======
	@Override
>>>>>>> master
	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		this.getDao().save(book);
	}

<<<<<<< HEAD
=======
	@Override
>>>>>>> master
	public void mergeBook(Book book) {
		// TODO Auto-generated method stub
		this.getDao().merge(book);
	}
<<<<<<< HEAD
=======
	@Override
>>>>>>> master
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		Book book = this.getDao().get(id);
		return book;
	}

<<<<<<< HEAD
=======
	@Override
>>>>>>> master
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

<<<<<<< HEAD
=======
	@Override
>>>>>>> master
	public void deleteBookById(int id) {
		// TODO Auto-generated method stub
		this.getDao().delete(id);
	}

<<<<<<< HEAD
=======
	@Override
>>>>>>> master
	public List<Book> getBookByNameOrISBN(String cond) {
		// TODO Auto-generated method stub
		return this.getDao().findByTwoProperty("BookName", "ISBN", cond);
	}

<<<<<<< HEAD
	public PageBean<Book> getPageBean(String cond, Integer pageNum) {
		//TODO:ï¿½ï¿½Ò³ï¿½ï¿½ï¿½ï¿½
=======
	@Override
	public PageBean<Book> getPageBean(String cond, Integer pageNum) {
		//TODO:·ÖÒ³ËÑË÷
>>>>>>> master
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
