package service;
import model.Librarian;
public class LibrarianServicelmpl extends BaseService<Librarian>implements LibrarianService{
	@Override
	public Librarian verify(String LibrarianName, String Password) {
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
}
