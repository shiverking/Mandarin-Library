package service;
import model.Admin;
public class AdminServiceImpl extends BaseService<Admin>implements AdminService{
	public Admin verify(String AdminName, String Password) {
		Admin admin = this.getDao().getSingle("AdminName", AdminName);//��ȡ�û���ΪAdminName�Ķ���
		if(admin == null) {
			return null;//���û������û����򷵻ؿ�ֵ
		}
		if(admin.getPassword().equals(Password)) {
			//������û�������������������,�򷵻ظ��û�
			return admin;
		}
		return null;
	}
	public String changePassword(String AdminName,String NewPassword)
	{
		Admin admin=this.getDao().getSingle("AdminName", AdminName);//��ȡ���޸Ķ���
		admin.setPassword(NewPassword);
		this.getDao().merge(admin);
		return "success";
	}
}
