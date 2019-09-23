package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import model.Admin;
import service.AdminService;

public class AdminAction extends BaseAction<Admin,AdminService> {
	private Admin tmpAdmin;//创建临时Admin
	/*登陆功能*/
	public String signin() throws Exception{
		String AdminName =this.getModel().getAdminName();//获取AdminName
		String Password  =this.getModel().getPassword();//获取输入的密码
		if(AdminName==null) {
			this.errorMessage="You must input an AdminName!";
			return INPUT;//返回登录页面
		}
		if(Password==null) {
			this.errorMessage="You must input the Password!";
			return INPUT;//返回登录页面
		}
		Admin admin = this.getService().verify(AdminName, Password);
		if(admin!=null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("admin", admin);//将admin存入session
			tmpAdmin = admin ;
			return SUCCESS;
		}
		this.errorMessage="Your name or password is wrong, please try again !";
		return INPUT;
	}
}
