package action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import model.Librarian;
import model.Reader;
import service.LibrarianService;

public class LibrarianAction extends BaseAction<Librarian,LibrarianService> {
	private Librarian librarian;
	private List<Librarian> Librarians;
	public Librarian getLibrarian() {
		return librarian;
	}
	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}
	public List<Librarian> getLibrarians() {
		return Librarians;
	}
	public void setLibrarians(List<Librarian> librarians) {
		Librarians = librarians;
	}
	/*闁跨喐鏋婚幏鐑芥*/
	public String signin() throws Exception{
		String LibrarianName =this.getModel().getLibrarianName();//闁跨喐鏋婚幏宄板絿LibrarianName
		String Password  =this.getModel().getPassword();//闁跨喐鏋婚幏宄板絿闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻弬銈嗗闁跨噦鎷�
		if(LibrarianName.isEmpty()) {
			System.out.println(LibrarianName);
			this.errorMessage="You must input the Name!";
			return INPUT;
		}
		if(Password.isEmpty()) {
			this.errorMessage="You must input the Password!";
			return INPUT;
		}
		Librarian Librarian = this.getService().verify(LibrarianName, Password);
		if(Librarian!=null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("librarian", Librarian);
			librarian = Librarian;
			return SUCCESS;
		}
		this.errorMessage="Your name or password is wrong, please try again !";
		return INPUT;
	}
	public String signout() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("librarian", null);
		return SUCCESS;
	}
	public String signup() throws Exception{
		String LibrarianName = this.getModel().getLibrarianName();//闁跨喐鏋婚幏宄板絿LibrarianName
		String Password = this.getModel().getPassword();//闁跨喐鏋婚幏宄板絿闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻弬銈嗗闁跨噦鎷�
		HttpServletRequest request = ServletActionContext.getRequest();
		String NewPassword=request.getParameter("ConfirmPassword");
		if(LibrarianName.isEmpty()) {
			this.errorMessage="You must input the Name!";
			return INPUT;
		}
		Librarian librarian = this.getService().verify(LibrarianName, Password);
		if(!NewPassword.equals(Password)) {
			this.errorMessage="Both passwords must be the same!";
			return INPUT;
		}
		if(librarian == null) {
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
	public String show()
	{
		this.Librarians=this.getService().show();
		return SUCCESS;
	}
	public String editLibrarian() {
		this.librarian=this.getService().getLibrarianByID(librarian.getLibrarianID());
		if(this.getModel().getLibrarianName()!=null) {
			librarian.setLibrarianName(this.getModel().getLibrarianName());
		}
		if(this.getModel().getPassword()!=null) {
			librarian.setPassword(this.getModel().getPassword());
		}
		this.getService().mergeLibrarian(librarian);
		return SUCCESS;
	}
	public String deleteLibrarian() {
		this.getService().deleteLibrarianById(librarian.getLibrarianID());
		return SUCCESS;
	}
	// 鑾峰彇褰撳墠lib鐘舵��
		public String getLibstatu() {
			Map<String, Object> session = ActionContext.getContext().getSession();
			librarian = (Librarian) session.get("librarian");
			if (librarian == null) {
				return NONE;
			}
			return SUCCESS;
		}
	public String findPassword()//admin 閹垫儳娲� librarian鐎靛棛鐖�
	{
		if(this.getService().findPassword(librarian.getLibrarianName())==null)
		{
			return "failure";
		}
		else {
			HttpSession session=ServletActionContext.getRequest().getSession();//鐏忓棗鐦戦惍浣哥摠閸掔殜ession娑擃叏绱濋崶鐘辫礋鐠囥儲鏌熷▔鏇熺�張澶婂讲閼充粙娓剁憰浣芥硶jsp娴肩娀锟芥帊淇婇幁锟�
			session.setAttribute("Password", this.getService().findPassword(librarian.getLibrarianName()));
			return "success";
		}
	}
	
}
