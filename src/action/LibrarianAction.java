package action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import model.Librarian;
import service.LibrarianService;

public class LibrarianAction extends BaseAction<Librarian,LibrarianService> {
	private Librarian tmpLibrarian;//������ʱLibrarian
	private List<Librarian> Librarains;
	public List<Librarian> getLibrarains() {
		return Librarains;
	}
	/*��½*/
	public String signin() throws Exception{
		String LibrarianName =this.getModel().getLibrarianName();//��ȡLibrarianName
		String Password  =this.getModel().getPassword();//��ȡ���������
		if(LibrarianName==null) {
			this.errorMessage="You must input the Name!";
			return INPUT;
		}
		if(Password==null) {
			this.errorMessage="You must input the Password!";
			return INPUT;
		}
		Librarian librarian = this.getService().verify(LibrarianName, Password);
		if(librarian!=null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("librarian", librarian);
			tmpLibrarian = librarian;
			return SUCCESS;
		}
		this.errorMessage="Your name or password is wrong, please try again !";
		return INPUT;
	}
	public String signup() throws Exception{
		String LibrarianName = this.getModel().getLibrarianName();//��ȡLibrarianName
		String Password = this.getModel().getPassword();//��ȡ���������
		HttpServletRequest request = ServletActionContext.getRequest();
		String NewPassword=request.getParameter("ConfirmPassword");
		int i=0;
		if(LibrarianName==null&&i == 0) {
			/*request.setAttribute("tipMessage", "You must input the Name!");
			i++;*/
			return INPUT;//����ע�����
		}
		if(Password==null) {
			Password="00010001";
		}
		Librarian librarian = this.getService().verify(LibrarianName, Password);
		if(NewPassword == null) {
			Password="00010001";
		}
		if(!NewPassword.equals(Password)&&i == 0) {
			/*request.setAttribute("tipMessage", "The two passwords you entered do not match!");
			i++;*/
			return INPUT;
		}
		if(librarian == null) {
			if(NewPassword.equals(Password)) {
		    	try {
					this.getService().register(this.getModel());
				}
				catch (Exception ex){
					/*this.addActionError(ex.getMessage());
					return INPUT;*/     //ҳ����ʾ��Ϣδʵ��
				}
		    	return SUCCESS;
			}
		}
		return INPUT;
	}
	public String show()
	{
		this.Librarains=this.getService().show();
		return SUCCESS;
	}
}
