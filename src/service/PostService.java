package service;

import java.util.List;

import model.Book;
import model.Librarian;
import model.Post;

public interface PostService {
	
	public List<Post> getAllPosts();
	public void savePost(Post post);
	public void deletePostByID(int ID);
	public void editPostByID(Post post);
	public Post getPostByID(int ID);
}