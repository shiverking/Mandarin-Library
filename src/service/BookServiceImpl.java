package service;

import java.util.List;
import model.Book;

public class BookServiceImpl extends BaseService<Book> implements BookService {

	public List<Book> getAllBooks(String cond) {
		// TODO Auto-generated method stub
		List<Book> books = this.getDao().findAll(cond);
		return books;
	}

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return getAllBooks(null);
	}

	public List<Book> getBooksByBookName(String BookName) {
		// TODO Auto-generated method stub
		return this.getDao().findBySubString("BookName", BookName);
	}

	@Override
	public List<Book> getThemesBySubString(String cond) {
		// TODO Auto-generated method stub
		return null;
	}

}
