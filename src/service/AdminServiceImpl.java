package service;
import model.Admin;
public class AdminServiceImpl extends BaseService<Admin>implements AdminService{
<<<<<<< HEAD
	public Admin verify(String AdminName, String Password) {
		Admin admin = this.getDao().getSingle("AdminName", AdminName);//��ȡ�û���ΪAdminName�Ķ���
		if(admin == null) {
			return null;//���û������û����򷵻ؿ�ֵ
		}
		if(admin.getPassword().equals(Password)) {
			//������û�������������������,�򷵻ظ��û�
=======
	@Override
	public Admin verify(String AdminName, String Password) {
		Admin admin = this.getDao().getSingle("AdminName", AdminName);//��ȡ�û���ΪAdminName�Ķ���
		if(admin == null) {
			return null;//���û������û����򷵻ؿ�ֵ
		}
		if(admin.getPassword().equals(Password)) {
			//������û�������������������,�򷵻ظ��û�
>>>>>>> master
			return admin;
		}
		return null;
	}
	public String changePassword(String AdminName,String NewPassword)
	{
<<<<<<< HEAD
		Admin admin=this.getDao().getSingle("AdminName", AdminName);//��ȡ���޸Ķ���
=======
		Admin admin=this.getDao().getSingle("AdminName", AdminName);//��ȡ���޸Ķ���
>>>>>>> master
		admin.setPassword(NewPassword);
		this.getDao().merge(admin);
		return "success";
	}
}
