package action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import model.Librarian;
import service.LibrarianService;
import util.Email;

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
	/*锟斤拷陆*/
	public String signin() throws Exception{
		String LibrarianName =this.getModel().getLibrarianName();//锟斤拷取LibrarianName
		String Password  =this.getModel().getPassword();//锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷锟�
		if(LibrarianName==null) {
			this.errorMessage="You must input the Name!";
			return INPUT;
		}
		if(Password==null) {
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
	public String signup() throws Exception{
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
		System.out.println("aaaa");
		int i = this.getModel().getLibrarianID();
		System.out.println(i);
		String n=this.getModel().getLibrarianName();
		String e=this.getModel().getEmail();
		String p=this.getModel().getPassword();
		this.librarian=this.getService().getLibrarianByID(i);
		this.librarian=this.getService().getLibrarianByID(librarian.getLibrarianID());
		if(this.getModel().getLibrarianName()!=null) {
			librarian.setLibrarianName(n);
		}
		if(this.getModel().getEmail()!=null)
		{
			librarian.setEmail(e);
			librarian.setLibrarianName(this.getModel().getLibrarianName());
		}
		if(this.getModel().getPassword()!=null) {
			librarian.setPassword(p);
			librarian.setPassword(this.getModel().getPassword());
		}
		this.getService().mergeLibrarian(librarian);
		return SUCCESS;
	}
	public String deleteLibrarian() {
		int i = this.getModel().getLibrarianID();
		System.out.println(i);
		this.getService().deleteLibrarianById(i);
		return SUCCESS;
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
			Email email=new Email(librarian.getEmail());
			email.sendEmail(librarian.getLibrarianName(),librarian.getPassword());
			return SUCCESS;
		}
	}
}
