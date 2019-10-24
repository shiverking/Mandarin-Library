package service;
import java.util.*;

import model.Admin;
public class AdminServiceImpl extends BaseService<Admin>implements AdminService{
	@Override
	public Admin verify(String AdminName, String Password) {
		Admin admin = this.getDao().getSingle("AdminName", AdminName);//获取用户名为AdminName的对象
		if(admin == null) {
			return null;//如果没有这个用户，则返回空值
		}
		if(admin.getPassword().equals(Password)) {
			//如果该用户的密码等于输入的密码,则返回该用户
			return admin;
		}
		return null;
	}
	public String changePassword(String AdminName,String NewPassword)
	{
		Admin admin=this.getDao().getSingle("AdminName", AdminName);//获取欲修改对象
		admin.setPassword(NewPassword);
		this.getDao().merge(admin);
		return "success";
	}
	public void modifyDeposity(int NewDeposit) {
		List<Admin> admins=this.getDao().findAll();
		Iterator<Admin> a=admins.iterator();
		while(a.hasNext())
		{
			Admin n=a.next();
			n.setSecurityDeposite(NewDeposit);
			this.getDao().merge(n);
		}
	}
	@Override
	public int getDeposit() {
		List<Admin> admins=this.getDao().findAll();
		return admins.get(0).getSecurityDeposite();
	}
}
