package model;

public class Librarian {
	private int LibrarianID;
	private String LibrarianName;
	private String Password;
	private String Email;
	public Librarian() {
		
	}
	public Librarian(int librarianID, String librarianName) {
		//super();
		LibrarianID = librarianID;
		LibrarianName = librarianName;
		Password = "123456";//��ʼ����Ϊ123456
	}
	public int getLibrarianID() {
		return LibrarianID;
	}
	public void setLibrarianID(int librarianID) {
		LibrarianID = librarianID;
	}
	public String getLibrarianName() {
		return LibrarianName;
	}
	public void setLibrarianName(String librarianName) {
		LibrarianName = librarianName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
}
