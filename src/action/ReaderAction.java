package action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import model.Librarian;
import model.Reader;
import service.ReaderService;
import util.PageBean;

public class ReaderAction extends BaseAction<Reader, ReaderService> {
	private Reader tempReader = new Reader();
	private List<Borrowrecord> borrowrecords;
	private String searchContent;
	private List<Reader> readers;
	private String errorMessage;
	private String filename;
	private Date readerDate;
	private int readerNum;
	private File avatarFile;
	private Librarian librarian;
	private PageBean<Reader> readerPage;
	private Integer pageNum;

	public String register() {
		Map<String, Object> session = ActionContext.getContext().getSession();// 妫�鏌ibrarian鐧诲綍鐘舵��
		librarian = (Librarian) session.get("librarian");
		this.errorMessage = null;
		if (librarian == null) {
			return INPUT;
		}
		if (this.getModel().getEmail().isEmpty()) {
			this.errorMessage = "You must input the Email!";
		} else if (this.getModel().getPhoneNumber().isEmpty()) {
			this.errorMessage = "You must input the phone number!";
		} else if (this.getModel().getReaderName().isEmpty()) {
			this.errorMessage = "You must input reader's namer!";
		} else if (this.getModel().getPhoneNumber().length() > 11) {
			this.errorMessage = "Your Phone Number is to long !";
		}
		this.getModel().setPassword("12345678");

		if (errorMessage == null) {
			tempReader = this.getService().getReaderbyPhone(this.getModel().getPhoneNumber());

			if (tempReader == null) {
				tempReader = this.getService().getReaderbyEmail(this.getModel().getEmail());
				if (tempReader == null) {
					readerDate=new Date();
					this.getService().mergeReader(this.getModel());
				} else {
					this.errorMessage = "This email has been bound to another account!";
				}
			} else {
				this.errorMessage = "This number has been bound to another account!";
			}
		}
		return SUCCESS;
	}

	public String getReaderForDelete() {
		Map<String, Object> session = ActionContext.getContext().getSession();//
		librarian = (Librarian) session.get("librarian");
		if (librarian == null) {
			return INPUT;
		}
		tempReader = this.getService().getReaderById(this.getModel().getReaderID());
		return SUCCESS;
	}

	public String deleteReader() {
		String realPath = ServletActionContext.getServletContext().getRealPath("upload");
		try {
			FileUtils.deleteDirectory(new File(realPath + "\\" + tempReader.getReaderID() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.getService().deleteReader(tempReader);
		return SUCCESS;
	}

	public String findReaderPage() {
		Map<String, Object> session = ActionContext.getContext().getSession();// 妫�鏌ibrarian鐧诲綍鐘舵��
		librarian = (Librarian) session.get("librarian");
		if (librarian == null) {
			return INPUT;
		}
		readerPage = this.getService().getPageBean(searchContent,pageNum);
		return SUCCESS;
	}

	public String setreader() {
		Map<String, Object> session = ActionContext.getContext().getSession();// 妫�鏌ibrarian鐧诲綍鐘舵��
		librarian = (Librarian) session.get("librarian");
		if (librarian == null) {
			return INPUT;
		}
		errorMessage = null;
		tempReader = this.getService().getReaderById(this.getModel().getReaderID());// 璇诲彇闇�瑕佷慨鏀圭殑璇昏��
		if (tempReader == null) {
			this.errorMessage = "This account does not exist";// 妫�鏌ユ槸鍚︽湁姝よ鑰�
			return SUCCESS;
		}

		if (!this.getModel().getEmail().isEmpty()) {// 鑻ユ彁浜ょ殑閭涓嶄负绌轰笖鏃犺处鍙风粦瀹氭閭锛屼慨鏀归偖绠�
			if (this.getService().getReaderbyEmail(this.getModel().getEmail()) != null && this.getService()
					.getReaderbyEmail(this.getModel().getEmail()).getReaderID() != tempReader.getReaderID()) {
				this.errorMessage = "This mailbox has been bound to another account.";
			} else {
				tempReader.setEmail(this.getModel().getEmail());
			}
		}
		if (!this.getModel().getPassword().isEmpty()) {
			HttpServletRequest request = ServletActionContext.getRequest();
			String NewPassword = request.getParameter("ConfirmPassword");
			if (!this.getModel().getPassword().equals(NewPassword)) {
				this.errorMessage = "Both passwords must be the same!";
			}
			tempReader.setPassword(this.getModel().getPassword());
		}
		if (!this.getModel().getReaderName().isEmpty())// 淇敼鍚嶅瓧
			tempReader.setReaderName(this.getModel().getReaderName());
		if (!this.getModel().getPhoneNumber().isEmpty()) {// 鑻ユ彁浜ょ殑鎵嬫満鍙蜂笉涓虹┖锛屼笖鏃犺处鍙蜂娇鐢ㄦ鎵嬫満鍙凤紝淇敼鎵嬫満鍙�
			if (this.getService().getReaderbyPhone(this.getModel().getPhoneNumber()) != null && this.getService()
					.getReaderbyPhone(this.getModel().getPhoneNumber()).getReaderID() != tempReader.getReaderID()) {
				this.errorMessage = "This phone number has been bound to another account.";
			} else {
				tempReader.setPhoneNumber(this.getModel().getPhoneNumber());
			}
		}
		if (errorMessage == null) {
			this.getService().mergeReader(tempReader);
		}
		return SUCCESS;
	}

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
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("reader", null);
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
		if (tempReader == null) {
			return LOGIN;
		}
		if (avatarFile == null) {
			this.errorMessage = "Only supports images in png and gif format.";
			return SUCCESS;
		}
		String suffix = filename.substring(filename.lastIndexOf(".") + 1);
		if (!suffix.equals("png") && !suffix.equals("gif")) {
			this.errorMessage = "Only supports images in png and gif format.";
			return SUCCESS;
		}
		String realPath = ServletActionContext.getServletContext().getRealPath("upload");
		try {
			FileUtils.copyFile(avatarFile, new File(realPath + "\\" + tempReader.getReaderID() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	// 閼惧嘲褰囪ぐ鎾冲鐠囨槒锟藉懐濮搁幀锟�
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

	public String getAllReader() {
		this.readers = this.getService().getAllReader();
		return SUCCESS;
	}

	public String getReaderById() {
		this.readers = new ArrayList<Reader>();
		int id = this.getModel().getReaderID();
		this.readers.add(this.getService().getReaderById(id));
		if (this.readers.get(0) == null) {
			this.setErrorMessage("ReaderNotFoundError: Can't Find Reader by id:" + id);
			System.out.println(this.getErrorMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getReaderByName() {
		String Name = this.getModel().getReaderName();
		this.readers = this.getService().getReaderByName(Name);
		if (this.readers.isEmpty()) {
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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getReaderNum() {
		return readerNum;
	}

	public void setReaderNum(int readerNum) {
		this.readerNum = readerNum;
	}

	public Librarian getLibrarian() {
		return librarian;
	}

	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}

	public PageBean<Reader> getReaderPage() {
		return readerPage;
	}

	public void setReaderPage(PageBean<Reader> readerPage) {
		this.readerPage = readerPage;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public String show() {
		this.readers=this.getService().show();
		return SUCCESS;
	}
	public Date getReaderDate() {
		return readerDate;
	}

	public void setReaderDate(Date readerDate) {
		this.readerDate = readerDate;
	}

}