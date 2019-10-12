package service;

import model.Admin;

public interface AdminService {
	public Admin verify(String AdminName, String Password);
	public String changePassword(String AdminName,String NewPassword);
	public void modifyDeposity(int NewDeposit);
	public int getDeposit();
}
