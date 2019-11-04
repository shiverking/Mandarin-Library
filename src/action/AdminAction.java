package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import model.Admin;
import service.AdminService;

public class AdminAction extends BaseAction<Admin,AdminService> {
	private Admin tmpAdmin;//闁告帗绋戠紓鎾寸▔鐎涙ɑ顦dmin
	private String NewSecurityDeposit;
	private int Deposit;
	
	//娴犮儰绗呮稉绨奺t閸滃疅et閺傝纭�
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
			return INPUT;//閺夆晜鏌ㄥú鏍儌鐠囪尙绉垮銈囨暬濞硷拷
		}
		if(Password.isEmpty()) {
			this.errorMessage="You must input the Password!";
			return INPUT;//閺夆晜鏌ㄥú鏍儌鐠囪尙绉垮銈囨暬濞硷拷
		}
		Admin admin = this.getService().verify(AdminName, Password);
		if(admin!=null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("admin", admin);//閻忓繐鎽砫min閻庢稒锚閸欏敄ession
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
		if(this.tmpAdmin==null)//绾喛顓婚悽銊﹀煕閺勵垰鎯侀崷銊ф瑜版洜濮搁崘锟 
		{
			return  LOGIN;
		}
		else if(this.getService().verify(tmpAdmin.getAdminName(), Password)!=null)//绾喛顓荤 靛棛鐖滈弰顖氭儊娑撳海鏁ら幋椋庢祲缁涳拷
		{
			 HttpServletRequest request=ServletActionContext.getRequest();
			 String NewPassword=request.getParameter("NewPassword");//閼惧嘲褰囬弬鎵畱鐎靛棛鐖 
			 if(NewPassword.isEmpty())
			 {
				 this.errorMessage="Please input the NewPassword";
				 return INPUT;
			 }
			 request=ServletActionContext.getRequest();
			 String ConfirmNewPassword=request.getParameter("ConfirmNewPassword");
			 if(ConfirmNewPassword.isEmpty())
			 {
				 this.errorMessage="Please input the ConfirmNewPassword";
				 return INPUT;
			 }
			 if(!ConfirmNewPassword.equals(NewPassword)) {
				 this.errorMessage=("Both passwords must be the same!");
				 return INPUT;
			 }
			 System.out.println(this.getService().changePassword(tmpAdmin.getAdminName(),NewPassword));
			 this.errorMessage=("Password change successfully!");
			return this.getService().changePassword(tmpAdmin.getAdminName(),NewPassword);
		}
		else //鐎靛棛鐖滈柨娆掝嚖闁插秵鏌婃潏鎾冲弳
		{
			this.errorMessage=("Original password error!");
			return INPUT;
		}
	}
	public String logout()//婵炲鍔戦弨銏㈡嫻閿曪拷瑜帮拷
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
	public String getMoney() {
		Deposit=this.getService().getDeposit();
		return SUCCESS;
		
	}
}
