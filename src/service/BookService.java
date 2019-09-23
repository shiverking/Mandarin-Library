package service;

import java.util.List;

import model.Book;
import model.Reader;

public interface BookService {
	public List<Book> getAllBooks();

	public List<Book> getAllBooks(String cond);

	public List<Book> getThemesBySubString(String cond);

}
