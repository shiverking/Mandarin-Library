package service;

import java.util.ArrayList;
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
		// TODO:·ÖÒ³ËÑË÷
		int current = 1;
		if (pageNum != null) {
			current = pageNum;
		}
		List<String> pnList = new ArrayList<String>();
		List<String> vList = new ArrayList<String>();
		pnList.add("ISBN");
		pnList.add("BookName");
		vList.add(cond);
		vList.add(cond);
		int totalRecords = this.getDao().findTotalNum(pnList, vList, 0, 0);
		PageBean<Book> bookPageBean = new PageBean<Book>(totalRecords, current);
		bookPageBean.setDataList(this.getDao().findPage(pnList, vList, null, 0, 0, 0, bookPageBean.getStartIndex(),
				bookPageBean.getPageSize()));
		return bookPageBean;
	}

	@Override
	public PageBean<Book> getPageBeanbyISBN(String isbn, Integer pageNum) {
		int current = 1;
		if (pageNum != null) {
			current = pageNum;
		}
		List<String> pnList = new ArrayList<String>();
		List<String> vList = new ArrayList<String>();
		pnList.add("ISBN");
		vList.add(isbn);
		int totalRecords = this.getDao().findTotalNum(pnList, vList, 0, 0);
		PageBean<Book> bookPageBean = new PageBean<Book>(totalRecords, current);
		bookPageBean.setDataList(this.getDao().findPage(pnList, vList, null, 0, 0, 0, bookPageBean.getStartIndex(),
				bookPageBean.getPageSize()));
		return bookPageBean;
	}

	@Override
	public PageBean<Book> getPageBeanbyTitle(String title, Integer pageNum) {
		int current = 1;
		if (pageNum != null) {
			current = pageNum;
		}
		List<String> pnList = new ArrayList<String>();
		List<String> vList = new ArrayList<String>();
		pnList.add("BookName");
		vList.add(title);
		int totalRecords = this.getDao().findTotalNum(pnList, vList, 0, 0);
		PageBean<Book> bookPageBean = new PageBean<Book>(totalRecords, current);
		bookPageBean.setDataList(this.getDao().findPage(pnList, vList, null, 0, 0, 0, bookPageBean.getStartIndex(),
				bookPageBean.getPageSize()));
		return bookPageBean;
	}

	@Override
	public PageBean<Book> getPageBeanbyAuthor(String author, Integer pageNum) {
		int current = 1;
		if (pageNum != null) {
			current = pageNum;
		}
		List<String> pnList = new ArrayList<String>();
		List<String> vList = new ArrayList<String>();
		pnList.add("Author");
		vList.add(author);
		int totalRecords = this.getDao().findTotalNum(pnList, vList, 0, 0);
		PageBean<Book> bookPageBean = new PageBean<Book>(totalRecords, current);
		bookPageBean.setDataList(this.getDao().findPage(pnList, vList, null, 0, 0, 0, bookPageBean.getStartIndex(),
				bookPageBean.getPageSize()));
		return bookPageBean;
		
	}

}
