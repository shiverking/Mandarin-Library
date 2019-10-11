package service;
import java.util.List;

import model.Librarian;
public class LibrarianServicelmpl extends BaseService<Librarian>implements LibrarianService{
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

	public Librarian getLibrarianByID(int id) {
		// TODO Auto-generated method stub
		Librarian librarian=this.getDao().get(id);
		return librarian;
	}

	public void mergeLibrarian(Librarian librarian) {
		// TODO Auto-generated method stub
		this.getDao().merge(librarian);
	}

	public void deleteLibrarianById(int librarianID) {
		// TODO Auto-generated method stub
		this.getDao().delete(librarianID);
	}
}
