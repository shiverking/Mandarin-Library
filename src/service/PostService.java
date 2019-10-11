package service;

import java.util.List;

import model.Post;

public interface PostService {
	
	public List<Post> display(String LibrarainID, String Title,String Content);
}