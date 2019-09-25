package service;
import model.Admin;
import model.Librarian;
public class LibrarianServicelmpl extends BaseService<Librarian> implements LibrarianService{
	@Override
	public Librarian verify(String LibrarianName, String Password) {
		Librarian librarian = this.getDao().getSingle("Libriarian", LibrarianName);//获取用户名为AdminName的对象
		if(librarian == null) {
			return null;//如果没有这个用户，则返回空值
		}
		if(librarian.getPassword().equals(Password)) {
			//如果该用户的密码等于输入的密码,则返回该用户
			return librarian;
		}
		return null;
	}
}
