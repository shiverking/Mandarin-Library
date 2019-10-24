package action;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/*import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.servlet.http.HttpServletRequest;*/

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import org.apache.commons.io.FileUtils;

/*import org.hibernate.SessionFactory;
*/
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
	private File avatarFile;

	public String signin() throws Exception {
		String phoneNumber = this.getModel().getPhoneNumber();
		String password = this.getModel().getPassword();

		if (phoneNumber.isEmpty() || phoneNumber == null) {
			this.errorMessage = "You must input your mobile number!";
			return INPUT;
		}
		if (password.isEmpty() || password == null) {
			this.errorMessage = "You must input your password!";
			return INPUT;
		}
		Reader reader = this.getService().verify(phoneNumber, password);
		if (reader != null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("reader", reader);
			this.tempReader = reader;
			return SUCCESS;
		}
		this.errorMessage = "Your mobile number or password is wrong!";
		return INPUT;
	}

	public String signout() throws Exception {
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}

	public String changeReaderName() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		tempReader = (Reader) session.get("reader");
		if (this.getModel().getReaderName().isEmpty()) {
			this.setErrorMessage("Please do not enter an empty name");
		} else {
			tempReader.setReaderName(this.getModel().getReaderName());
			this.setErrorMessage("The name was successfully modified");
		}
		this.getService().mergeReader(tempReader);
		return SUCCESS;
	}

//	changeReaderPassword
	public String changeReaderPassword() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		tempReader = (Reader) session.get("reader");
		this.getService().mergeReader(tempReader);
		return SUCCESS;
	}

	public String changeReaderAvatar() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		tempReader = (Reader) session.get("reader");
		if (tempReader==null) {
			return LOGIN;
		}
		if (avatarFile==null) {
			this.errorMessage="Please select an image.";
			return SUCCESS;
		}
		String realPath = ServletActionContext.getServletContext().getRealPath("upload");
		try {
			FileUtils.copyFile(avatarFile, new File(realPath+"\\"+tempReader.getPhoneNumber()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	// 获取当前读者状态
	public String getReaderStatu() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		this.tempReader = (Reader) session.get("reader");
		if (tempReader == null) {
			return NONE;
		}
		return SUCCESS;
	}

	public String forgetReaderPassword() throws Exception {
//		HttpServletRequest PaswordRequest = ServletActionContext.getRequest();
//		String email = PaswordRequest.getParameter("Email");
		boolean a = this.getService().forgetReaderPassword(this.getModel().getEmail());
		if (a == true) {
			this.errorMessage = "An email has been sent to your mailbox, please check it in time";
			return SUCCESS;
		} else {
			this.errorMessage = "Your email is wrong!";
			return INPUT;
		}
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

	public File getAvatarFile() {
		return avatarFile;
	}

	public void setAvatarFile(File avatarFile) {
		this.avatarFile = avatarFile;
	}

}