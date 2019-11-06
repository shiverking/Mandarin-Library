package service;

import java.util.ArrayList;
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

	public PageBean<Book> getPageBean(String cond, String categoryString, Integer pageNum) {
		// TODO:·ÖÒ³ËÑË÷
		int current = 1;
		if (pageNum != null) {
			current = pageNum;
		}
		List<String> pnList = new ArrayList<String>();
		List<String> vList = new ArrayList<String>();
		if (categoryString != null) {
			categoryString += ",";
			pnList.add("category");
			vList.add(categoryString);
		}
		pnList.add("ISBN");
		pnList.add("BookName");
		vList.add(cond);
		vList.add(cond);
		int totalRecords;
		PageBean<Book> bookPageBean;
		if (categoryString != null) {
			totalRecords = this.getDao().findTotalNum(pnList, vList, 1, 0);
			bookPageBean = new PageBean<Book>(totalRecords, current);
			bookPageBean.setDataList(this.getDao().findPage(pnList, vList, null, 1, 0, 0, bookPageBean.getStartIndex(),
					bookPageBean.getPageSize()));
		} else {
			totalRecords = this.getDao().findTotalNum(pnList, vList, 0, 0);
			bookPageBean = new PageBean<Book>(totalRecords, current);
			bookPageBean.setDataList(this.getDao().findPage(pnList, vList, null, 0, 0, 0, bookPageBean.getStartIndex(),
					bookPageBean.getPageSize()));
		}
		return bookPageBean;
	}

	public PageBean<Book> getPageBeanbyISBN(String isbn, String categoryString, Integer pageNum) {
		int current = 1;
		if (pageNum != null) {
			current = pageNum;
		}
		List<String> pnList = new ArrayList<String>();
		List<String> vList = new ArrayList<String>();
		if (categoryString != null) {
			categoryString += ",";
			pnList.add("category");
			vList.add(categoryString);
		}
		pnList.add("ISBN");
		vList.add(isbn);
		int totalRecords;
		PageBean<Book> bookPageBean;
		if (categoryString != null) {
			totalRecords = this.getDao().findTotalNum(pnList, vList, 1, 0);
			bookPageBean = new PageBean<Book>(totalRecords, current);
			bookPageBean.setDataList(this.getDao().findPage(pnList, vList, null, 1, 0, 0, bookPageBean.getStartIndex(),
					bookPageBean.getPageSize()));
		} else {
			totalRecords = this.getDao().findTotalNum(pnList, vList, 0, 0);
			bookPageBean = new PageBean<Book>(totalRecords, current);
			bookPageBean.setDataList(this.getDao().findPage(pnList, vList, null, 0, 0, 0, bookPageBean.getStartIndex(),
					bookPageBean.getPageSize()));
		}
		return bookPageBean;
	}

	public PageBean<Book> getPageBeanbyTitle(String title, String categoryString, Integer pageNum) {
		int current = 1;
		if (pageNum != null) {
			current = pageNum;
		}
		List<String> pnList = new ArrayList<String>();
		List<String> vList = new ArrayList<String>();
		if (categoryString != null) {
			categoryString += ",";
			pnList.add("category");
			vList.add(categoryString);
		}
		pnList.add("BookName");
		vList.add(title);
		int totalRecords;
		PageBean<Book> bookPageBean;
		if (categoryString != null) {
			totalRecords = this.getDao().findTotalNum(pnList, vList, 1, 0);
			bookPageBean = new PageBean<Book>(totalRecords, current);
			bookPageBean.setDataList(this.getDao().findPage(pnList, vList, null, 1, 0, 0, bookPageBean.getStartIndex(),
					bookPageBean.getPageSize()));
		} else {
			totalRecords = this.getDao().findTotalNum(pnList, vList, 0, 0);
			bookPageBean = new PageBean<Book>(totalRecords, current);
			bookPageBean.setDataList(this.getDao().findPage(pnList, vList, null, 0, 0, 0, bookPageBean.getStartIndex(),
					bookPageBean.getPageSize()));
		}
		return bookPageBean;
	}

	public PageBean<Book> getPageBeanbyAuthor(String author, String categoryString, Integer pageNum) {
		int current = 1;
		if (pageNum != null) {
			current = pageNum;
		}
		List<String> pnList = new ArrayList<String>();
		List<String> vList = new ArrayList<String>();
		if (categoryString != null) {
			categoryString += ",";
			pnList.add("category");
			vList.add(categoryString);
		}
		pnList.add("Author");
		vList.add(author);
		int totalRecords;
		PageBean<Book> bookPageBean;
		if (categoryString != null) {
			totalRecords = this.getDao().findTotalNum(pnList, vList, 1, 0);
			bookPageBean = new PageBean<Book>(totalRecords, current);
			bookPageBean.setDataList(this.getDao().findPage(pnList, vList, null, 1, 0, 0, bookPageBean.getStartIndex(),
					bookPageBean.getPageSize()));
		} else {
			totalRecords = this.getDao().findTotalNum(pnList, vList, 0, 0);
			bookPageBean = new PageBean<Book>(totalRecords, current);
			bookPageBean.setDataList(this.getDao().findPage(pnList, vList, null, 0, 0, 0, bookPageBean.getStartIndex(),
					bookPageBean.getPageSize()));
		}
		return bookPageBean;

	}

	public List<String> getCategory(String cond, Integer select) {
		List<String> pnList = new ArrayList<String>();
		List<String> vList = new ArrayList<String>();
		if (select != null) {
			switch (select) {
			case 1: {
				pnList.add("ISBN");
				pnList.add("BookName");
				vList.add(cond);
				vList.add(cond);
			}
				break;
			case 2: {
				pnList.add("ISBN");
				vList.add(cond);
			}
				break;
			case 3: {
				pnList.add("BookName");
				vList.add(cond);
			}
				break;
			case 4: {
				pnList.add("Author");
				vList.add(cond);
			}
				break;
			default:
				break;
			}
			return this.getDao().findSingleField(pnList, vList, "category", 0, 0);
		}
		// TODO Auto-generated method stub
		return null;
	}

}
