package service;
import model.Admin;
public class AdminServiceImpl extends BaseService<Admin>implements AdminService{
	@Override
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
}
