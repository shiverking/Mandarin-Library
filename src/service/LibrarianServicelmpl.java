package service;
import java.util.List;

import model.Librarian;
public class LibrarianServicelmpl extends BaseService<Librarian>implements LibrarianService{
	@Override
	public Librarian verify(String LibrarianName, String Password) {
		if(Password==null) {Password="00010001";}
		Librarian librarian = this.getDao().getSingle("LibrarianName",LibrarianName);
		if(librarian == null) {
			return null;//如果没有这个用户，则返回空值
		}
		if(librarian.getPassword().equals(Password)) {
			//如果该用户的密码等于输入的密码,则返回该用户
			return librarian;
		}
		return null;
	}

	@Override
	public void register(Librarian librarian) {
		// TODO Auto-generated method stub
		if(librarian.getPassword()=="") {
			librarian.setPassword("00010001");
		}
		this.getDao().save(librarian);
	}
	public List<Librarian> show()
	{
		return this.getDao().findAll();
	}
}
