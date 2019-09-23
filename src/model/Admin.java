package model;

public class Admin {
	private int AdminID;
	private String AdminName;
	private String Password;
	private int SecurityDeposite;
	
	public Admin() {
		
	}
	public Admin(int adminID, String adminName) {
		//super();
		AdminID = adminID;
		AdminName = adminName;
		Password = "00010001";
		SecurityDeposite = 300;
	}
	public int getAdminID() {
		return AdminID;
	}
	public void setAdminID(int adminID) {
		AdminID = adminID;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getSecurityDeposite() {
		return SecurityDeposite;
	}
	public void setSecurityDeposite(int securityDeposite) {
		SecurityDeposite = securityDeposite;
	}
}
