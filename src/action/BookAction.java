package action;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import service.BookService;

/**
* @author 
* @version ����ʱ�䣺2019��9��24�� ����2:12:32
* 
*/
public class BookAction extends BaseAction<Book, BookService>{
private List<Book> books=new ArrayList<Book>();

public List<Book> getBooks() {
	return books;
}

public void setBooks(List<Book> books) {
	this.books = books;
}

}
