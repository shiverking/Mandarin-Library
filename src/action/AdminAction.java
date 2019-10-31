package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import model.Admin;
import service.AdminService;

public class AdminAction extends BaseAction<Admin,AdminService> {
	private Admin tmpAdmin;//閸掓稑缂撴稉瀛樻Admin
	private String NewSecurityDeposit;
	private int Deposit;
	
	//浠ヤ笅涓簊et鍜実et鏂规硶
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
		String AdminName =this.getModel().getAdminName();
		String Password  =this.getModel().getPassword();
		System.out.println(AdminName);
		if(AdminName.isEmpty()) {
			this.errorMessage="You must input an AdminName!";
			return INPUT;//鏉╂柨娲栭惂璇茬秿妞ょ敻娼�
		}
		if(Password.isEmpty()) {
			this.errorMessage="You must input the Password!";
			return INPUT;//鏉╂柨娲栭惂璇茬秿妞ょ敻娼�
		}
		Admin admin = this.getService().verify(AdminName, Password);
		if(admin!=null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("admin", admin);//鐏忓摳dmin鐎涙ê鍙唖ession
			tmpAdmin = admin ;
			System.out.println("success");
			return SUCCESS;
		}
		else{
			this.errorMessage="Your name or password is wrong, please try again !";
			return INPUT;
		}
	}
	public String changePassword()
	{
		String Password  =this.getModel().getPassword();//閼惧嘲褰嘝assword
		Map<String, Object> session = ActionContext.getContext().getSession();
		this.tmpAdmin= (Admin) session.get("admin");
		if(this.tmpAdmin==null)//绾喛顓婚悽銊﹀煕閺勵垰鎯侀崷銊ф瑜版洜濮搁崘锟�
		{
			return  LOGIN;
		}
		else if(this.getService().verify(tmpAdmin.getAdminName(), Password)!=null)//绾喛顓荤�靛棛鐖滈弰顖氭儊娑撳海鏁ら幋椋庢祲缁涳拷
		{
			 HttpServletRequest request=ServletActionContext.getRequest();
			 String NewPassword=request.getParameter("NewPassword");//閼惧嘲褰囬弬鎵畱鐎靛棛鐖�
			 System.out.println(this.getService().changePassword(tmpAdmin.getAdminName(),NewPassword));
			return this.getService().changePassword(tmpAdmin.getAdminName(),NewPassword);
		}
		else //鐎靛棛鐖滈柨娆掝嚖闁插秵鏌婃潏鎾冲弳
		{
			return INPUT;
		}
	}
	public String logout()//濞夈劑鏀㈢拹锕�褰�
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
	public String modify()//
	{
		try{
			int money=Integer.parseInt(NewSecurityDeposit);
			if(money>=0)
			{
			this.getService().modifyDeposity(money);
			return "success";
			}
			else
			{
				this.errorMessage="The SecurityDeposit must to be greater than 0  ";
				return INPUT;
			}
		}catch(NumberFormatException e)
		{
			this.errorMessage="Please enter integer"; 
			return INPUT;
		}
	}
	public String dm() {
		NewSecurityDeposit=this.getService().getDeposit()+"";
		return "success";
	}
}
