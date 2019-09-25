package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import model.Reader;
import service.ReaderService;

public class ReaderAction extends BaseAction<Reader, ReaderService> {
	private Reader tempReader;
	private String searchContent;
	private List<Reader> readers;
	
	public String signin() throws Exception {
		String ReaderName = this.getModel().getReaderName();
		String Password = this.getModel().getPassword();
		
		if (ReaderName == null) {
			this.errorMessage = "You must input your readerName!";
			return INPUT;
		}
		if (Password == null) {
			this.errorMessage = "You must input your password!";
			return INPUT;
		}
		Reader reader = this.getService().verify(ReaderName,Password);
		if (reader != null) {
			Map<String,Object> session = ActionContext.getContext().getSession();
			session.put("Reader", reader);
			tempReader = reader;
			return SUCCESS;
		}
		this.errorMessage="Your name or password is wrong, please try again !";
		return INPUT;
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

}