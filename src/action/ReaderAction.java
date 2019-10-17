package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import model.Reader;
import service.ReaderService;

public class ReaderAction extends BaseAction<Reader, ReaderService> {
	private Reader tempReader = new Reader();
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
		if (Password.isEmpty()||Password==null) {
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

}