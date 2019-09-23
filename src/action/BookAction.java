package action;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import model.Book;
import model.Reader;
import service.BookService;

public class BookAction {
	private List<Book> booktable = new ArrayList<Book>();
	private Reader temReader;
	private String searchContent;
	private List<Reader> readers;

	public String searchBook() {
		booktable = this.getService().getBooksByBookName(searchContent);
		return "success";
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

}
