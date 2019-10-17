package action;

import java.util.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import model.Librarian;
import service.LibrarianService;
//import util.Email;

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
	/*閿熸枻鎷烽檰*/
	public String signin() throws Exception{
		String LibrarianName =this.getModel().getLibrarianName();//閿熸枻鎷峰彇LibrarianName
		String Password  =this.getModel().getPassword();//閿熸枻鎷峰彇閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿燂拷
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
		String LibrarianName = this.getModel().getLibrarianName();//閿熸枻鎷峰彇LibrarianName
		String Email = this.getModel().getEmail();//鑾峰彇閭
		String Password = this.getModel().getPassword();//閿熸枻鎷峰彇閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿燂拷
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
		if(this.getModel().getLibrarianName()!=null) {
			librarian.setLibrarianName(n);
		}
		if(this.getModel().getEmail()!=null)
		{
			librarian.setEmail(e);
		}
		if(this.getModel().getPassword()!=null) {
			librarian.setPassword(p);
		}
		this.getService().mergeLibrarian(librarian);
		return SUCCESS;
	}
	public String deleteLibrarian() {
		this.getService().deleteLibrarianById(librarian.getLibrarianID());
		return SUCCESS;
	}
	public String findPassword() throws Exception//admin 鎵惧洖 librarian瀵嗙爜
	{
		if(this.getService().findID(librarian.getLibrarianName())==0)
		{
			return "failure";
		}
		else {
			/*HttpSession session=ServletActionContext.getRequest().getSession();//灏嗗瘑鐮佸瓨鍒皊ession涓紝鍥犱负璇ユ柟娉曟瀬鏈夊彲鑳介渶瑕佽法jsp浼犻�掍俊鎭�
			session.setAttribute("Password", this.getService().findPassword(librarian.getLibrarianName()));
			return "success";*/
			this.librarian=this.getService().getLibrarianByID(this.getService().findID(librarian.getLibrarianName()));			
//			Email email=new Email(librarian.getEmail());
//			email.sendEmail(librarian.getLibrarianName(),librarian.getPassword());
			return SUCCESS;
		}
	}
}
