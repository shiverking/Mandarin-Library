package action;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import model.Admin;
import service.AdminService;

public class AdminAction extends BaseAction<Admin,AdminService> {
	private Admin tmpAdmin;//������ʱAdmin
	/*��½����*/
	public String signin() throws Exception{
		String AdminName =this.getModel().getAdminName();//��ȡAdminName
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
	public String changePassword()
	{
		String Password  =this.getModel().getPassword();//��ȡPassword
		Map<String, Object> session = ActionContext.getContext().getSession();
		this.tmpAdmin= (Admin) session.get("admin");
		if(this.tmpAdmin==null)//ȷ���û��Ƿ��ڵ�¼״��
		{
			return  LOGIN;
		}
		else if(this.getService().verify(tmpAdmin.getAdminName(), Password)!=null)//ȷ�������Ƿ����û����
		{
			 HttpServletRequest request=ServletActionContext.getRequest();
			 String NewPassword=request.getParameter("NewPassword");//��ȡ�µ�����
			 System.out.println(this.getService().changePassword(tmpAdmin.getAdminName(),NewPassword));
			return this.getService().changePassword(tmpAdmin.getAdminName(),NewPassword);
		}
		else //���������������
		{
			return INPUT;
		}
	}
	public String logout()//ע���˺�
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session==null)
		{
			return "failure";
		}
		else
		{
			session.clear();
			return "success";
		}
	}
}
