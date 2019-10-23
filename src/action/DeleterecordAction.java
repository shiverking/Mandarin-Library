package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import model.*;
import service.DeleterecordService;
import util.PageBean;

/**
 * @author
 * @version 
 * 
 */
public class DeleterecordAction extends BaseAction<Deleterecord, DeleterecordService> {

	private Reader tempReader;
	private List<Book> books;// ¿ÉÄÜ±»É¾³ý
	private Integer pageNum;
	private String isbn1;
	
	public String addRecord() throws Exception {
		int deleterecordID = this.getModel().getDeleterecordID();
		Date date = new Date();
		String iSBN = this.isbn1;
		System.out.print("****************************"+iSBN);
		this.getModel().setDeleterecordID(deleterecordID);
		this.getModel().setISBN(isbn1);
		this.getModel().setDate(date);
		Map<String, Object> session = ActionContext.getContext().getSession();
		this.getModel().setLibrarian((Librarian) session.get("librarian")); 
		this.getService().saveDeleterecord(this.getModel());
		return SUCCESS;
	}

	public String getIsbn1() {
		return isbn1;
	}

	public void setIsbn1(String isbn1) {
		this.isbn1 = isbn1;
	}


}
