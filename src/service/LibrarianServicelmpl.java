package service;
import java.util.List;

import model.Librarian;
public class LibrarianServicelmpl extends BaseService<Librarian>implements LibrarianService{
	@Override
	public Librarian verify(String LibrarianName, String Password) {
		if(Password==null) {Password="00010001";}
		Librarian librarian = this.getDao().getSingle("LibrarianName",LibrarianName);
		if(librarian == null) {
			return null;//���û������û����򷵻ؿ�ֵ
		}
		if(librarian.getPassword().equals(Password)) {
			//������û�������������������,�򷵻ظ��û�
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
