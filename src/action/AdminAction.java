package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import model.Admin;
import service.AdminService;

public class AdminAction extends BaseAction<Admin,AdminService> {
	private Admin tmpAdmin;//������ʱAdmin
	/*��½����*/
	public String signin() throws Exception{
		
		String Password  =this.getModel().getPassword();//��ȡ���������
		if(AdminName==null) {
			this.errorMessage="You must input an AdminName!";
			return INPUT;//���ص�¼ҳ��
		}
		if(Password==null) {
			this.errorMessage="You must input the Password!";
			return INPUT;//���ص�¼ҳ��
		}
		Admin admin = this.getService().verify(AdminName, Password);
		if(admin!=null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("admin", admin);//��admin����session
			tmpAdmin = admin ;
			return SUCCESS;
		}
		this.errorMessage="Your name or password is wrong, please try again !";
		return INPUT;
	}
}
