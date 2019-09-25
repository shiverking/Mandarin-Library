package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import model.Librarian;
import service.LibrarianService;

public class LibrarianAction extends BaseAction<Librarian,LibrarianService> {
	private Librarian tmpLibrarian;//������ʱLibrarian
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
}
