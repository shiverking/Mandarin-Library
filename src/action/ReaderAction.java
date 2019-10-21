package action;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionContext;

import model.Reader;
import service.ReaderService;

public class ReaderAction extends BaseAction<Reader, ReaderService> {
	private Reader tempReader = new Reader();
	private String searchContent;
	private List<Reader> readers;
	private String errorMessage;

	public String signin() throws Exception {
		String phoneNumber = this.getModel().getPhoneNumber();
		String password = this.getModel().getPassword();

		if (phoneNumber.isEmpty()||phoneNumber==null) {
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

	public String gotoReaderSelfProfile() {
//    	Map<String, Object> session = ActionContext.getContext().getSession();
//    	this.tempReader = (Reader) session.get("reader");
//    	if(tempReader==null) {
//    		return INPUT;
//    	}
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
		if (this.getModel().getPassword().isEmpty()) {
			this.setErrorMessage("Please enter a non-empty password");
		} else {
			tempReader.setPassword(this.getModel().getPassword());
		}
		this.setErrorMessage("Password reset complete");
		this.getService().mergeReader(tempReader);

		return SUCCESS;
	}

	// 锟斤拷取锟矫伙拷锟斤拷状态
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

}