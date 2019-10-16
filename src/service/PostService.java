package service;

import java.util.List;

import model.Book;
import model.Borrowrecord;
import model.Librarian;
import model.Post;
import util.PageBean;

public interface PostService {
	
	public List<Post> getAllPosts();
	public List<Post> getAllPosts(String cond);
	public void savePost(Post post);
	public Post getPostById(int id);
	public List<Post> getPostByTitle(String cond);
	public List<Post> getPostsByContent(String cond);
	public void deletePostById(int id);
	public List<Post> getBookByTitleorContent(String cond1);
	PageBean<Post> getPageBean(String cond,Integer pageNum);
}