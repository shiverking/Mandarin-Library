package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import model.Admin;
import service.AdminService;

public class AdminAction extends BaseAction<Admin,AdminService> {
	private Admin tmpAdmin;//鍒涘缓涓存椂Admin
	private String NewSecurityDeposit;
	private int Deposit;
	
	//以下为set和get方法
	public int getDeposit() {
		return this.getService().getDeposit();
	}
	public void setDeposit(int deposit) {
		Deposit = this.getService().getDeposit();
	}
	public String getNewSecurityDeposit() {
		return NewSecurityDeposit;
	}
	public void setNewSecurityDeposit(String newSecurityDeposit) {
		NewSecurityDeposit = newSecurityDeposit;
	}
	public String signin() throws Exception{
		String AdminName =this.getModel().getAdminName();//鑾峰彇AdminName
		String Password  =this.getModel().getPassword();//鑾峰彇杈撳叆鐨勫瘑鐮�?
		if(AdminName==null) {
			this.errorMessage="You must input an AdminName!";
			return INPUT;//杩斿洖鐧诲綍椤甸�?
		}
		if(Password==null) {
			this.errorMessage="You must input the Password!";
			return INPUT;//杩斿洖鐧诲綍椤甸�?
		}
		Admin admin = this.getService().verify(AdminName, Password);
		if(admin!=null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("admin", admin);//灏哸dmin瀛樺叆session
			tmpAdmin = admin ;
			return SUCCESS;
		}
		this.errorMessage="Your name or password is wrong, please try again !";
		return INPUT;
	}
	public String changePassword()
	{
		String Password  =this.getModel().getPassword();//鑾峰彇Password
		Map<String, Object> session = ActionContext.getContext().getSession();
		this.tmpAdmin= (Admin) session.get("admin");
		if(this.tmpAdmin==null)//纭鐢ㄦ埛鏄惁鍦ㄧ櫥褰曠姸鍐�?
		{
			return  LOGIN;
		}
		else if(this.getService().verify(tmpAdmin.getAdminName(), Password)!=null)//纭瀵嗙爜鏄惁涓庣敤鎴风浉绛�
		{
			 HttpServletRequest request=ServletActionContext.getRequest();
			 String NewPassword=request.getParameter("NewPassword");//鑾峰彇鏂扮殑瀵嗙�?
			 System.out.println(this.getService().changePassword(tmpAdmin.getAdminName(),NewPassword));
			return this.getService().changePassword(tmpAdmin.getAdminName(),NewPassword);
		}
		else //瀵嗙爜閿欒閲嶆柊杈撳叆
		{
			return INPUT;
		}
	}

	public String logout()//娉ㄩ攢璐﹀�?
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

	public String modify()//修改用户缴纳的保证金
	{
		int money=Integer.parseInt(NewSecurityDeposit);
		this.getService().modifyDeposity(money);
		System.out.println(Deposit);
		return "success";
	}
	public String dm() {
		NewSecurityDeposit=this.getService().getDeposit()+"";
		System.out.println("s");
		return "success";
	}
}
