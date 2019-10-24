package service;
import java.util.List;

import model.Librarian;
public class LibrarianServiceImpl extends BaseService<Librarian>implements LibrarianService{
	@Override
	public Librarian verify(String LibrarianName, String Password) {
		if(Password==null) {Password="00010001";}
		Librarian librarian = this.getDao().getSingle("LibrarianName",LibrarianName);
		if(librarian == null) {
			return null;
		}
		if(librarian.getPassword().equals(Password)) {
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

	@Override
	public Librarian getLibrarianByID(int id) {
		// TODO Auto-generated method stub
		Librarian librarian=this.getDao().get(id);
		return librarian;
	}

	@Override
	public void mergeLibrarian(Librarian librarian) {
		// TODO Auto-generated method stub
		this.getDao().merge(librarian);
	}

	@Override
	public void deleteLibrarianById(int librarianID) {
		// TODO Auto-generated method stub
		this.getDao().delete(librarianID);
	}

	@Override
	public String findPassword(String LibrarianName) {
		if(this.getDao().getSingle("LibrarianName", LibrarianName)!=null)
		{
			return this.getDao().getSingle("LibrarianName", LibrarianName).getPassword();
		}
		return null;
	}
}
