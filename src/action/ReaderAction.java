package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

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
	private int readerNum;
	public int getReaderNum() {
		return readerNum;
	}
	public void setReaderNum(int readerNum) {
		this.readerNum = readerNum;
	}
		//读者注册
		public String register() throws Exception{
			String ReaderName = this.getModel().getReaderName();
			String PhoneNUmber = this.getModel().getPhoneNumber();

			String Email = this.getModel().getEmail();
			String Password = this.getModel().getPassword();
			HttpServletRequest request = ServletActionContext.getRequest();
			String NewPassword=request.getParameter("ConfirmPassword");
			if(Email.isEmpty()) {
				this.errorMessage="You must input the Email!";
				return INPUT;
			}
			Reader reader = this.getService().verify(Email, Password);
			if(!NewPassword.equals(Password)) {
				this.errorMessage="Both passwords must be the same!";
				return INPUT;
			}
			if(reader == null) {
				if(NewPassword.equals(Password)) {
			    	try {
						this.getService().register(this.getModel());
					}
					catch (Exception ex){
						this.addActionError(ex.getMessage());
						return INPUT;

					}
			    	return SUCCESS;
				}
			}
			this.errorMessage="Your name or password is wrong, please try again !";
			return INPUT;
		}
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
		this.readers = new ArrayList<Reader>();
		int id = this.getModel().getReaderID();
		this.readers.add(this.getService().getReaderById(id));
		if(this.readers.get(0) == null){
			this.setErrorMessage("ReaderNotFoundError: Can't Find Reader by id:" + id);
			System.out.println(this.getErrorMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getReaderByName(){
		String Name = this.getModel().getReaderName();
		this.readers = this.getService().getReaderByName(Name);
		if(this.readers.isEmpty()){
			this.setErrorMessage("ReaderNotFoundError: Can't Find Reader by name:" + Name);
			System.out.println(this.getErrorMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getReadersbyBorrwrecords() {
		readers = new ArrayList<Reader>();
		for (Borrowrecord borrowrecord : borrowrecords) {
			readers.add(this.getService().getReaderByBorrowrecord(borrowrecord));
		}
		return SUCCESS;
	}
	public String findReaderNum() {
		readerNum = this.getService().getReaderNum();
		return SUCCESS;
	}
}