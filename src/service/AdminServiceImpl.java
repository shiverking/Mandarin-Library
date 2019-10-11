package service;
import model.Admin;
public class AdminServiceImpl extends BaseService<Admin>implements AdminService{
<<<<<<< HEAD
	public Admin verify(String AdminName, String Password) {
		Admin admin = this.getDao().getSingle("AdminName", AdminName);//ï¿½ï¿½È¡ï¿½Ã»ï¿½ï¿½ï¿½ÎªAdminNameï¿½Ä¶ï¿½ï¿½ï¿½
		if(admin == null) {
			return null;//ï¿½ï¿½ï¿½Ã»ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ã»ï¿½ï¿½ï¿½ï¿½ò·µ»Ø¿ï¿½Öµ
		}
		if(admin.getPassword().equals(Password)) {
			//ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ã»ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½,ï¿½ò·µ»Ø¸ï¿½ï¿½Ã»ï¿½
=======
	@Override
	public Admin verify(String AdminName, String Password) {
		Admin admin = this.getDao().getSingle("AdminName", AdminName);//»ñÈ¡ÓÃ»§ÃûÎªAdminNameµÄ¶ÔÏó
		if(admin == null) {
			return null;//Èç¹ûÃ»ÓÐÕâ¸öÓÃ»§£¬Ôò·µ»Ø¿ÕÖµ
		}
		if(admin.getPassword().equals(Password)) {
			//Èç¹û¸ÃÓÃ»§µÄÃÜÂëµÈÓÚÊäÈëµÄÃÜÂë,Ôò·µ»Ø¸ÃÓÃ»§
>>>>>>> master
			return admin;
		}
		return null;
	}
	public String changePassword(String AdminName,String NewPassword)
	{
<<<<<<< HEAD
		Admin admin=this.getDao().getSingle("AdminName", AdminName);//ï¿½ï¿½È¡ï¿½ï¿½ï¿½Þ¸Ä¶ï¿½ï¿½ï¿½
=======
		Admin admin=this.getDao().getSingle("AdminName", AdminName);//»ñÈ¡ÓûÐÞ¸Ä¶ÔÏó
>>>>>>> master
		admin.setPassword(NewPassword);
		this.getDao().merge(admin);
		return "success";
	}
}
