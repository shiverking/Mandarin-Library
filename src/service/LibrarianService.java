package service;

import model.Librarian;

public interface LibrarianService {
	public Librarian verify(String LibrarianName, String Password);

	public void register(Librarian librarian);
}
