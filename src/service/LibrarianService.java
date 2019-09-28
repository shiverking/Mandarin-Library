package service;

import java.util.List;

import model.Librarian;

public interface LibrarianService {
	public Librarian verify(String LibrarianName, String Password);

	public void register(Librarian librarian);
	public List<Librarian> show();
}
