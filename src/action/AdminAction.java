package action;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

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
	public String changePassword()
	{
		String Password  =this.getModel().getPassword();//获取Password
		Map<String, Object> session = ActionContext.getContext().getSession();
		this.tmpAdmin= (Admin) session.get("admin");
		if(this.tmpAdmin==null)//确认用户是否在登录状况
		{
			return  LOGIN;
		}
		else if(this.getService().verify(tmpAdmin.getAdminName(), Password)!=null)//确认密码是否与用户相等
		{
			 HttpServletRequest request=ServletActionContext.getRequest();
			 String NewPassword=request.getParameter("NewPassword");//获取新的密码
			 System.out.println(this.getService().changePassword(tmpAdmin.getAdminName(),NewPassword));
			return this.getService().changePassword(tmpAdmin.getAdminName(),NewPassword);
		}
		else //密码错误重新输入
		{
			return INPUT;
		}
	}
	public String logout()//注销账号
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
