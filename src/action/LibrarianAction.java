package action;

import java.util.*;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import model.Admin;
import model.Librarian;
import model.Reader;
import service.LibrarianService;
import util.Email;
import util.Mail3;

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
		String LibrarianName =this.getModel().getLibrarianName();//锟斤拷取LibrarianName
		String Password  =this.getModel().getPassword();//锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷锟�
		if(LibrarianName.isEmpty()) {
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
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("admin")==null) {
			return "login";
		};
		String LibrarianName = this.getModel().getLibrarianName();//锟斤拷取LibrarianName
		String Email = this.getModel().getEmail();//获取邮箱
		String Password = this.getModel().getPassword();//锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷锟�
		HttpServletRequest request = ServletActionContext.getRequest();
		String NewPassword=request.getParameter("ConfirmPassword");
		if(LibrarianName.isEmpty()) {
			this.errorMessage="You must input the Name!";
			return INPUT;
		}
		if(Email.isEmpty()) {
			this.errorMessage="You must input the Email!";
			return INPUT;
		}
		Librarian librarian = this.getService().getLibrarianByName(LibrarianName);
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
		if(librarian!=null)
		{
			this.errorMessage="The user name has been registered";
			return INPUT;
		}
		return INPUT;
	}
	public String show()
	{
		this.Librarians=this.getService().show();
		return SUCCESS;
	}
	public String editLibrarian() {

		String n=this.getModel().getLibrarianName();
		String e=this.getModel().getEmail();
		String p=this.getModel().getPassword();
		System.out.println("ERROE MESSAGE: "+errorMessage);
		if(n.isEmpty())
		{
			HttpServletRequest request= ServletActionContext.getRequest();
			request.setAttribute("errorMessage","Please input the Librarian Name");
			this.errorMessage="Please input the Librarian Name";
			return INPUT;
		}
		if(e.isEmpty())
		{
			HttpServletRequest request= ServletActionContext.getRequest();
			request.setAttribute("errorMessage","Please input the Librarian Email");
			this.errorMessage="Please input the Librarian Email";
			return INPUT;
		}
		if(this.getModel().getPassword().isEmpty())
		{
			HttpServletRequest request= ServletActionContext.getRequest();
			request.setAttribute("errorMessage","Please input the Librarian Password");
			this.errorMessage="Please input the Librarian Password";

			return INPUT;
		}
		int i = this.getModel().getLibrarianID();
		this.librarian=this.getService().getLibrarianByID(i);
		librarian.setLibrarianName(n);
		librarian.setEmail(e);
		librarian.setPassword(p);
		this.getService().mergeLibrarian(librarian);
		return SUCCESS;
	}
	public String deleteLibrarian() {
		int i = this.getModel().getLibrarianID();
		this.getService().deleteLibrarianById(i);
		return SUCCESS;
	}

	// 获取当前lib状态
		public String getLibstatu() {
			Map<String, Object> session = ActionContext.getContext().getSession();
			librarian = (Librarian) session.get("librarian");
			if (librarian == null) {
				return NONE;
			}
			return SUCCESS;
		}
	public String search()
	{
		this.librarian=this.getService().getLibrarianByName(librarian.getLibrarianName());
		if(librarian!=null) {
			return SUCCESS;
		}
		return INPUT;
	}
	public String findPassword() throws Exception//admin 找回 librarian密码
	{
		if(this.getService().findID(librarian.getLibrarianName())==0)
		{
			return "failure";
		}
		else {
			/*HttpSession session=ServletActionContext.getRequest().getSession();//将密码存到session中，因为该方法极有可能需要跨jsp传递信息
			session.setAttribute("Password", this.getService().findPassword(librarian.getLibrarianName()));
			return "success";*/
			this.librarian=this.getService().getLibrarianByID(this.getService().findID(librarian.getLibrarianName()));			
			Mail3 email=new Mail3(librarian.getEmail());
			email.sendEmail(librarian.getLibrarianName(),librarian.getPassword());
			this.errorMessage="Send successfully!";
			return SUCCESS;
		}
	}

}
