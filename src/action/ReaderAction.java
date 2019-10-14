package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import model.Book;
import model.Borrowrecord;
import model.Reader;
import service.ReaderService;

public class ReaderAction extends BaseAction<Reader, ReaderService> {
	private Reader tempReader = new Reader();
	private List<Borrowrecord> borrowrecords;
	private String searchContent;
	private List<Reader> readers;
	private String errorMessage;

	public String signin() throws Exception {
		String Email = this.getModel().getEmail();
		String Password = this.getModel().getPassword();

		if (Email.isEmpty()) {
			this.errorMessage = "You must input your Email!";
			return INPUT;
		}
		if (Password.isEmpty()) {
			this.errorMessage = "You must input your password!";
			return INPUT;
		}
		Reader reader = this.getService().verify(Email, Password);
		if (reader != null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("reader", reader);
			this.tempReader = reader;
			return SUCCESS;
		}
		this.errorMessage = "Your email or password is wrong!";
		return INPUT;
	}

	// ��ȡ�û���״̬
	public String getReaderStatu() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		this.tempReader = (Reader) session.get("reader");
		if (tempReader == null) {
			return NONE;
		}
		return SUCCESS;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public List<Borrowrecord> getBorrowrecords() {
		return borrowrecords;
	}

	public void setBorrowrecords(List<Borrowrecord> borrowrecords) {
		this.borrowrecords = borrowrecords;
	}
	
	public List<Reader> getReaders() {
		return readers;
	}

	public void setReaders(List<Reader> readers) {
		this.readers = readers;
	}

	public String signout() throws Exception {
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}

	public Reader getTempReader() {
		return tempReader;
	}

	public void setTempReader(Reader tempReader) {
		this.tempReader = tempReader;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getAllReader(){
		this.readers = this.getService().getAllReader();
		return SUCCESS;
	}
	
	public String getReaderById(){
		int id = this.getModel().getReaderID();
		this.readers = this.getService().getReadersByID(id);
		return SUCCESS;
	}
	
	public String getReaderByName(){
		String Name = this.getModel().getReaderName();
		this.readers = this.getService().getReaderByName(Name);
		return SUCCESS;
	}
	
	public String getReadersbyBorrwrecords() {
		readers = new ArrayList<Reader>();
		for (Borrowrecord borrowrecord : borrowrecords) {
			readers.add(this.getService().getReaderByBorrowrecord(borrowrecord));
		}
		return SUCCESS;
	}

}