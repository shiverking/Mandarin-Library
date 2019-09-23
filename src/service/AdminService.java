package service;

import model.Admin;

public interface AdminService {
	public Admin verify(String AdminName, String Password);
}
